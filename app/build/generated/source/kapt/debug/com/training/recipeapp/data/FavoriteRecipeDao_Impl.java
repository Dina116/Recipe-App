package com.training.recipeapp.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteRecipeDao_Impl implements FavoriteRecipeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteRecipe> __insertionAdapterOfFavoriteRecipe;

  private final EntityDeletionOrUpdateAdapter<FavoriteRecipe> __deletionAdapterOfFavoriteRecipe;

  public FavoriteRecipeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteRecipe = new EntityInsertionAdapter<FavoriteRecipe>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `favorite_recipes` (`id`,`user_name`,`title`,`image_url`,`ingredients`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteRecipe entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUsername() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUsername());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitle());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageUrl());
        }
        if (entity.getIngredients() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getIngredients());
        }
      }
    };
    this.__deletionAdapterOfFavoriteRecipe = new EntityDeletionOrUpdateAdapter<FavoriteRecipe>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `favorite_recipes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteRecipe entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public void insertRecipe(final FavoriteRecipe recipe) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavoriteRecipe.insert(recipe);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object delete(final FavoriteRecipe recipe, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavoriteRecipe.handle(recipe);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<FavoriteRecipe>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorite_recipes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"favorite_recipes"}, false, new Callable<List<FavoriteRecipe>>() {
      @Override
      @Nullable
      public List<FavoriteRecipe> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "user_name");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfIngredients = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredients");
          final List<FavoriteRecipe> _result = new ArrayList<FavoriteRecipe>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavoriteRecipe _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpIngredients;
            if (_cursor.isNull(_cursorIndexOfIngredients)) {
              _tmpIngredients = null;
            } else {
              _tmpIngredients = _cursor.getString(_cursorIndexOfIngredients);
            }
            _item = new FavoriteRecipe(_tmpId,_tmpUsername,_tmpTitle,_tmpImageUrl,_tmpIngredients);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
