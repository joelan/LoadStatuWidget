package crazyjone.aacproject.Services.Model.CommonModel;

/**
 * Created by Administrator on 2017/11/16.
 */

public enum Status {

    SUCCESS(2),ERROR(0),LOADING(1);

    int value;


    Status(int value)
    {
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
