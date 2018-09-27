package com.tcm.call;

public interface HystrixCallBack {

    <T> T run(String requestmodel);
}
