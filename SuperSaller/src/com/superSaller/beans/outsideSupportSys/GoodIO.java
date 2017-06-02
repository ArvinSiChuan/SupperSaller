package com.superSaller.beans.outsideSupportSys;

import java.util.ArrayList;

import com.superSaller.beans.outsideSupportSys.entities.Good;

public interface GoodIO {
	public Good getGood(String goodID);

	public ArrayList<Good> fuzzyQuery(String goodID);

}
