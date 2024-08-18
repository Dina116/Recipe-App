package com.training.recipeapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/training/recipeapp/data/UserDao;", "", "clearAllUsers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUser", "Landroidx/lifecycle/LiveData;", "", "Lcom/training/recipeapp/data/User;", "getUserByEmail", "email", "", "insert", "user", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.training.recipeapp.data.User user);
    
    @androidx.room.Query(value = "SELECT * FROM users WHERE email = :email LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract com.training.recipeapp.data.User getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email);
    
    @androidx.room.Query(value = "SELECT * FROM  users")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.training.recipeapp.data.User>> getAllUser();
    
    @androidx.room.Query(value = "DELETE FROM users")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearAllUsers(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}