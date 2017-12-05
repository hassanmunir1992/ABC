package com.example.tintash.abc.data.utils;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.tintash.abc.data.dao.GenericDao;

/**
 * Created by Tintash on 12/5/2017.
 */

public class CRUDAsyncTask<T> extends AsyncTask<Integer, Integer, Boolean> {


    public interface CRUDAsyncTaskCallback {
        public void onPreExecute();

        public void onProgressUpdate(int progress);

        public void onPostExecute(boolean done);
    }

    public static final int INSERT = 1;
    public static final int DELETE = 2;
    public static final int UPDATE = 3;
    public static final int READ = 4;
    public static final int CONFLICT_INSERT = 5;

    private GenericDao genericDao;

    private T[] entities;

    private CRUDAsyncTaskCallback crudAsyncTaskCallback;

    private MutableLiveData<Boolean> crudAsyncTaskLiveData;

    public CRUDAsyncTask(GenericDao genericDao, CRUDAsyncTaskCallback crudAsyncTaskCallback, T... entities) {
        this.genericDao = genericDao;
        this.entities = entities;
        this.crudAsyncTaskCallback = crudAsyncTaskCallback;
        this.crudAsyncTaskLiveData = new MutableLiveData<>();
    }



    @Override
    public void onPreExecute() {
        super.onPreExecute();
        if (this.crudAsyncTaskCallback != null) {
            this.crudAsyncTaskCallback.onPreExecute();
        }
    }

    @Override
    public Boolean doInBackground(Integer... operations) {
        if (this.genericDao != null) {
            //getting operation
            int operation = operations[0];
            switch (operation) {
                case INSERT: {
                    this.genericDao.insert(this.entities);
                    return true;
                }

                case DELETE: {
                    this.genericDao.delete(this.entities);
                    return true;
                }

                case UPDATE: {
                    this.genericDao.update(this.entities);
                    return true;
                }

                case READ: {
                    return false;
                }

                case CONFLICT_INSERT: {
//                    ((UserDao) genericDao).insertUser((User) this.entities[0]);
                    return true;
                }

                default: {
                    return false;
                }
            }
        }

        return false;
    }

    public LiveData<Boolean> getAsyncTaskLiveData() {
        return this.crudAsyncTaskLiveData;
    }

    @Override
    public void onProgressUpdate(Integer... progresses) {
        //getting progress
        if (progresses != null && progresses.length > 0) {
            int progress = progresses[0];
            if (this.crudAsyncTaskCallback != null) {
                this.crudAsyncTaskCallback.onProgressUpdate(progress);
            }
        }
    }

    @Override
    public void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if (this.crudAsyncTaskCallback != null) {
            this.crudAsyncTaskCallback.onPostExecute(result);
        }
        if (this.crudAsyncTaskLiveData != null) {
            this.crudAsyncTaskLiveData.setValue(result);
        }

    }


}

