package com.zhangxinran.ObServer;

import com.zhangxinran.ObServer.Observer;

public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
