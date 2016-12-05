package fr.loicmathieu.dojo.pattern.lambdaspec.spec;

import fr.loicmathieu.dojo.pattern.lambdaspec.LeafSpecification;
import fr.loicmathieu.dojo.pattern.specification.SpecificationTest.Obj1;


public class ComplexSpecification extends LeafSpecification<Obj1> {

	@Override
	public boolean isSatisfiedBy(Obj1 obj) {
		return "TEXT".equalsIgnoreCase(obj.getText()) ||
				"THE_TEXT".equalsIgnoreCase(obj.getText()) ||
				"TEST".equalsIgnoreCase(obj.getText()) ||
				"A_TEST".equalsIgnoreCase(obj.getText()) ||
				"POULP".equalsIgnoreCase(obj.getText());
	}

}
