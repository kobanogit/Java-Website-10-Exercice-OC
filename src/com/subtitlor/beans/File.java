package com.subtitlor.beans;

import com.subtitlor.beans.BeanException;

public class File {
	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title)  throws BeanException {
//		if (titre.length() > 10) {
//      throw new BeanException("Le nom est trop grand ! (10 caractères maximum)");
//	  }
//	  else {
//	      this.titre = titre; 
//	  }
		this.title = title; 
	}

}
