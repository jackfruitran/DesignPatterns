package com.zhangxinran.ObServer.ObServerMyself;

import java.util.Vector;

public class Observable {
    private boolean changed = false;
    Vector<Observer> obs;

    public Observable() {
        obs = new Vector<>();
    }

    //向可观察者里注册观察者
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o))
            obs.addElement(o);
    }

    public synchronized void deleteElement(Observer o) {
        obs.removeElement(o);
    }

    public void notifyObserver() {
        notifyObserver(null);
    }

    public void notifyObserver(Object arg) {
        Object[] arrlocal;
        synchronized (this) {
            if (!changed)
                return;
            arrlocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrlocal.length - 1; i >= 0; i--) {
            ((Observer) arrlocal[i]).update(this, arg);
        }
    }

    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    private void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return obs.size();
    }
}
