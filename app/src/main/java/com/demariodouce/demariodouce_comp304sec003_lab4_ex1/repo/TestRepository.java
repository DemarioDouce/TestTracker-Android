package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.TestDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database.TestDatabase;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;

import java.util.List;

public class TestRepository {
    private final TestDao testDao;

    public TestRepository(Context context) {
        TestDatabase db = TestDatabase.getInstance(context);
        testDao = db.testDao ();
    }

    public LiveData<List<TestEntity>> testList;

   public LiveData<List<TestEntity>> allTests(int id) {
        return testDao.alltests (id ) ;}

    public void insertTest(TestEntity testEntity) {
        new insertTestAsyncTask(testDao).execute(testEntity);

    }

    private static class insertTestAsyncTask extends AsyncTask<TestEntity, Void, Void> {

        private TestDao tAsyncTaskDao;

        insertTestAsyncTask(TestDao dao) {
            tAsyncTaskDao = dao;
        }

        protected Void doInBackground(final TestEntity... params) {
            tAsyncTaskDao.insertTest(params[0]);
            return null;
        }
    }
}
