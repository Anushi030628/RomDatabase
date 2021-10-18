package com.example.romdatabase.DaoClass;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.romdatabase.EntityClass.UserModel;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert

    void insertAllData(UserModel model);

    @Query("select * from user")
    List<UserModel> getAllData();

    @Query("delete from user where `key`=:id")
    void deleteData(int id);

    @Query("update user SET name=:name, number=:number where `key`=:key" )
    void updateData(String name,String number,int key);


}
