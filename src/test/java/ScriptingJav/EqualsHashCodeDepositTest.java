package ScriptingJav;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ScriptingJav.Alive.Captain;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Vibe;
import ScriptingJav.Objects.Coffers;
import ScriptingJav.Objects.abstraction.Size;
import ScriptingJav.Objects.abstraction.State;


public class EqualsHashCodeDepositTest {

    private Captain captain1;
    private Captain captain2;
    private Captain captain3;
    private Coffers coffers1;
    private Coffers coffers2;
    private Coffers coffers3;

    @BeforeEach
    void setUp() {
        captain1 = new Captain();
        captain1.name = "TestCaptain";
        captain1.age = 35;
        captain1.job = Job.Captain;
        captain1.vibe = Vibe.Official;

        captain2 = new Captain();
        captain2.name = "TestCaptain";
        captain2.age = 35;
        captain2.job = Job.Captain;
        captain2.vibe = Vibe.Official;

        captain3 = new Captain();
        captain3.name = "DifferentCaptain";
        captain3.age = 40;
        captain3.job = Job.Captain;
        captain3.vibe = Vibe.Practical;

        Coffers.CoffersData data1 = new Coffers.CoffersData(
            "Test Treasury", Size.Medium, State.GOOD, 1000.0, "High", false
        );
        Coffers.CoffersData data2 = new Coffers.CoffersData(
            "Test Treasury", Size.Medium, State.GOOD, 1000.0, "High", false
        );
        Coffers.CoffersData data3 = new Coffers.CoffersData(
            "Different Treasury", Size.Large, State.PERFECT, 2000.0, "Maximum", true
        );

        coffers1 = new Coffers(data1);
        coffers2 = new Coffers(data2);
        coffers3 = new Coffers(data3);
    }



    @Test
    void testEquals_ReflexiveProperty() {
        // Test 1: An object should be equal to itself (reflexive property)
        assertTrue(captain1.equals(captain1), "Object should be equal to itself");
        assertTrue(coffers1.equals(coffers1), "Coffers should be equal to itself");
    }

    @Test
    void testEquals_SymmetricProperty() {
        // Test 2: If A equals B, then B should equal A (symmetric property)
        assertTrue(captain1.equals(captain2), "captain1 should equal captain2");
        assertTrue(captain2.equals(captain1), "captain2 should equal captain1 (symmetric)");
        
        assertTrue(coffers1.equals(coffers2), "coffers1 should equal coffers2");
        assertTrue(coffers2.equals(coffers1), "coffers2 should equal coffers1 (symmetric)");
    }

    @Test
    void testEquals_TransitiveProperty() {
        // Test 3: If A equals B and B equals C, then A should equal C (transitive property)
        Captain captain4 = new Captain();
        captain4.name = "TestCaptain";
        captain4.age = 35;
        captain4.job = Job.Captain;
        captain4.vibe = Vibe.Official;

        assertTrue(captain1.equals(captain2), "captain1 equals captain2");
        assertTrue(captain2.equals(captain4), "captain2 equals captain4");
        assertTrue(captain1.equals(captain4), "captain1 should equal captain4 (transitive)");
    }

    @Test
    void testEquals_NotEqualWhenDifferentValues() {
        // Test 4: Objects with different field values should not be equal
        assertFalse(captain1.equals(captain3), "captain1 should not equal captain3 (different name)");
        assertFalse(coffers1.equals(coffers3), "coffers1 should not equal coffers3 (different data)");
        
        // Test with different age
        Captain captain5 = new Captain();
        captain5.name = "TestCaptain";
        captain5.age = 50; // Different age
        captain5.job = Job.Captain;
        captain5.vibe = Vibe.Official;
        assertFalse(captain1.equals(captain5), "captain1 should not equal captain5 (different age)");
    }

    @Test
    void testEquals_NullAndDifferentClass() {
        // Test 5: equals() should return false for null and different class types
        assertFalse(captain1.equals(null), "Object should not equal null");
        assertFalse(coffers1.equals(null), "Coffers should not equal null");
        
        // Test with different class
        String notACaptain = "I am not a Captain";
        assertFalse(captain1.equals(notACaptain), "Captain should not equal String");
        
        // Test Coffers with different class
        assertFalse(coffers1.equals(captain1), "Coffers should not equal Captain");
    }

    // ========== HASHCODE() TESTS ==========

    @Test
    void testHashCode_EqualObjectsHaveSameHashCode() {
        // Test 6: If two objects are equal, they must have the same hashCode
        assertEquals(captain1.hashCode(), captain2.hashCode(), 
            "Equal Captain objects must have same hashCode");
        assertEquals(coffers1.hashCode(), coffers2.hashCode(), 
            "Equal Coffers objects must have same hashCode");
    }

    @Test
    void testHashCode_Consistency() {
        // Test 7: hashCode() should return the same value for the same object (consistency)
        int hashCode1 = captain1.hashCode();
        int hashCode2 = captain1.hashCode();
        int hashCode3 = captain1.hashCode();
        
        assertEquals(hashCode1, hashCode2, "hashCode should be consistent (call 1 vs 2)");
        assertEquals(hashCode2, hashCode3, "hashCode should be consistent (call 2 vs 3)");
        
        int coffersHash1 = coffers1.hashCode();
        int coffersHash2 = coffers1.hashCode();
        assertEquals(coffersHash1, coffersHash2, "Coffers hashCode should be consistent");
    }

    @Test
    void testHashCode_DifferentObjectsMayHaveDifferentHashCodes() {
        // Test 8: Different objects (that are not equal) may have different hashCodes
        // Note: This is not a requirement, but it's good practice
        int hash1 = captain1.hashCode();
        int hash3 = captain3.hashCode();
        
        // They might be different (though hash collisions are possible)
        // We just verify they are different objects
        assertNotEquals(captain1, captain3, "Objects should be different");
        
        // For Coffers
        int coffersHash1 = coffers1.hashCode();
        int coffersHash3 = coffers3.hashCode();
        assertNotEquals(coffers1, coffers3, "Coffers objects should be different");
    }

    // ========== DEPOSIT() TESTS ==========

    @Test
    void testDeposit_IncreasesGoldAmount() {
        // Test 9: deposit() should increase the gold amount in Coffers
        double initialAmount = coffers1.getGoldAmount();
        double depositAmount = 500.0;
        
        coffers1.deposit(depositAmount);
        
        double expectedAmount = initialAmount + depositAmount;
        assertEquals(expectedAmount, coffers1.getGoldAmount(), 0.01, 
            "Gold amount should increase by deposit amount");
    }

    @Test
    void testDeposit_MultipleDepositsAccumulate() {
        // Test 10: Multiple deposits should accumulate correctly
        double initialAmount = coffers1.getGoldAmount();
        double deposit1 = 200.0;
        double deposit2 = 300.0;
        double deposit3 = 150.0;
        
        coffers1.deposit(deposit1);
        coffers1.deposit(deposit2);
        coffers1.deposit(deposit3);
        
        double expectedTotal = initialAmount + deposit1 + deposit2 + deposit3;
        assertEquals(expectedTotal, coffers1.getGoldAmount(), 0.01, 
            "Multiple deposits should accumulate correctly");
    }
}

