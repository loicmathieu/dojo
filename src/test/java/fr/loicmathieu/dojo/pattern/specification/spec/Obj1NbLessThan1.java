package fr.loicmathieu.dojo.pattern.specification.spec;

import fr.loicmathieu.dojo.pattern.specification.LeafSpecification;
import fr.loicmathieu.dojo.pattern.specification.SpecificationTest.Obj1;



public class Obj1NbLessThan1  extends LeafSpecification<Obj1> {
	@Override
	public boolean isSatisfiedBy(Obj1 obj) {
		return obj.getNb() < 1;
	}
}
