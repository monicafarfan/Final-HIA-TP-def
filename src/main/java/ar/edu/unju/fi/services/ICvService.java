package ar.edu.unju.fi.services;

import ar.edu.unju.fi.entity.Cv;

public interface ICvService {
	public Cv getCv();
	public boolean saveCv(Cv cv);
	public boolean modifyCv(Cv cv);
	public boolean isComplete(Cv cv);
}
