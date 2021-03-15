package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.PatientDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database.PatientDatabase;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;

import java.util.List;

public class PatientRepository {

    private final PatientDao patientDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<PatientEntity>> patientList;
    //
    public PatientRepository(Context context) {
        //create a database object
        PatientDatabase db = PatientDatabase.getInstance(context);
        //create an interface object
        patientDao = db.patientDao();
        //call interface method
        patientList = patientDao.getAllPatients();
    }
    // returns query results as LiveData object
    public LiveData<List<PatientEntity>> getAllPatients() {
        return patientList;
    }
    //inserts a patient asynchronously
    public void insert(PatientEntity patientEntity) {
        insertAsync(patientEntity);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    //Load patient by ID
    public LiveData<PatientEntity> loadPatient(final int patientId) {
        return patientDao.loadPatient (patientId);
    }
    //
    public void update(PatientEntity patientEntity) {
        new updateAsyncTask(patientDao).execute(patientEntity);

    }

    private static class updateAsyncTask extends AsyncTask<PatientEntity, Void, Void> {

        private PatientDao uAsyncTaskDao;

        updateAsyncTask(PatientDao dao) {
            uAsyncTaskDao = dao;
        }


        protected Void doInBackground(final PatientEntity... params) {
            uAsyncTaskDao.updatePatient (params[0]);
            return null;
        }
    }
//Delete
public void delete(PatientEntity patientEntity) {
    new deleteAsyncTask(patientDao).execute(patientEntity);

}


    private void insertAsync(final PatientEntity patientEntity) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.insert(patientEntity);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private static class deleteAsyncTask extends AsyncTask<PatientEntity, Void, Void> {

        private PatientDao dAsyncTaskDao;

        deleteAsyncTask(PatientDao dao) {
            dAsyncTaskDao = dao;
        }

        protected Void doInBackground(final PatientEntity... params) {
            dAsyncTaskDao.deletePatient (params[0]);
            return null;
        }

    }
}
