package com.nagal.design;

import com.nagal.design.designPatterns.prototype.MangoTree;
import com.nagal.design.designPatterns.prototype.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DesignApplicationTests {


	@Test
	public void givenAPlasticTreePrototypeWhenClonedThenCreateA_Clone() {

		double mass = 10.0;
		double height = 3.7;
		Position position = new Position(3, 7);
		Position otherPosition = new Position(4, 8);

		MangoTree mangoTree = new MangoTree(mass, height);
		mangoTree.setPosition(position);
		MangoTree anotherMangoTree = (MangoTree) mangoTree.copy();
		anotherMangoTree.setPosition(otherPosition);

		assertEquals(position, mangoTree.getPosition());
		assertEquals(otherPosition, anotherMangoTree.getPosition());

	}
}
