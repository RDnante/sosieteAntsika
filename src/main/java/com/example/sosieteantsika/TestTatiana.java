package com.example.sosieteantsika;

import com.example.sosieteantsika.model.Service_besoin;

public class TestTatiana {
    public static void main(String[] args) throws Exception{
        Service_besoin sb = new Service_besoin();
        sb.insertServiceBesoin(null, 1, 1, 50);
    }
}
