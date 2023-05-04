package ch.dkrieger.coinsystem.core.storage.storage;

public enum StorageType {

    SQLITE(),
    MYSQL();

    public static StorageType parse(String name){
        try{
            return valueOf(name.toUpperCase());
        }catch (Exception exception){}
        return SQLITE;
    }
}
