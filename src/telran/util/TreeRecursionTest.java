package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeRecursionTest {
TreeSet<Integer> tree;
	@BeforeEach
	void setUp() throws Exception {
		tree = new TreeSet<>();
		tree.add(30);
		tree.add(40);
		tree.add(35);
		tree.add(80);
		tree.add(60);
		tree.add(100);
		tree.add(90);
		tree.add(15);
		
	}

	@Test
	void widthTest() {
		assertEquals(4, tree.width());
	}
	@Test
	void heightTest() {
		assertEquals(5, tree.height());
	}
	@Test
	void displayTreeTest() {
		System.out.println("=====Tree=====");
		tree.displayTree();
	}
	@Test
	void maxBranchSumTest() {
		TreeSet<Integer> tree1 = getTreeForTest();
		assertEquals(340, tree.sumOfMaxBranch());
		assertEquals(36, tree1.sumOfMaxBranch());
		System.out.println("=====Tree1=====");
		tree1.displayTree();
	}

	private TreeSet<Integer> getTreeForTest() {
		// TODO create tree on the slide #38
		TreeSet<Integer> treeSet = new TreeSet<>((a, b)->getDigitsSumRegular(a) - getDigitsSumRegular(b));
		int array[] = {4, 6, 5, 7, 11, 21};
		for(int a:array) {
			treeSet.add(a);
		}
		return treeSet;
		// Done
	}
	@Test
	void displayTreeFileSystemTest() {
		System.out.println("=====TreeFileSystem=====");
		tree.displayTreeFileSystem();
	}
	// Recursive digits sum calculation
    private int getDigitsSumRecursive(int number) {
        if(number == 0){
          return 0 ;
        }     
        return (number % 10) + getDigitsSumRecursive(number / 10) ;
    }
	// Non Recursive digits sum calculation
    private int getDigitsSumRegular(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

}
