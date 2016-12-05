package fr.loicmathieu.dojo.pattern.lambdaspec.spec;

import fr.loicmathieu.dojo.pattern.lambdaspec.LeafSpecification;
import fr.loicmathieu.dojo.pattern.lambdaspec.SpecificationTest.Obj1;


public class Obj1NbLessThan1  extends LeafSpecification<Obj1> {
	@Override
	public boolean isSatisfiedBy(Obj1 obj) {
		return obj.getNb() > 10;
	}
}
