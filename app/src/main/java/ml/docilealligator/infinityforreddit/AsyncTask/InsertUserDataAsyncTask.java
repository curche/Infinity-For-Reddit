package ml.docilealligator.infinityforreddit.AsyncTask;

import android.os.AsyncTask;

import ml.docilealligator.infinityforreddit.User.UserData;
import ml.docilealligator.infinityforreddit.User.UserDao;

public class InsertUserDataAsyncTask extends AsyncTask<Void, Void, Void> {
    private UserDao userDao;
    private UserData userData;
    private InsertUserDataCallback insertUserDataCallback;

    public interface InsertUserDataCallback {
        void insertSuccess();
    }

    public InsertUserDataAsyncTask(UserDao userDao, UserData userData, InsertUserDataCallback insertUserDataCallback) {
        this.userDao = userDao;
        this.userData = userData;
        this.insertUserDataCallback = insertUserDataCallback;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        userDao.insert(userData);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(insertUserDataCallback != null) {
            insertUserDataCallback.insertSuccess();
        }
    }
}