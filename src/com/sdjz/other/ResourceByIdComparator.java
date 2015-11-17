package com.sdjz.other;

import java.util.Comparator;

import com.sdjz.domain.Resource;

public class ResourceByIdComparator implements Comparator<Resource>{

	@Override
	public int compare(Resource resource1, Resource resource2) {
		// TODO Auto-generated method stub
		return resource1.getId().compareTo(resource2.getId());
	}

}
