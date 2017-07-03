/* 
 * Copyright (C) 2017 César Astudillo <cesar dot astudillo at gmail dot com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pmx.PMX;

/**
 * Test files for the PMX class
 * @author César Astudillo <cesar dot astudillo at gmail dot com>
 */
public class PMXTest {
    
    public PMXTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    
    /**
     * Example taken from https://www.youtube.com/watch?v=ZtaHg1C25Kk
     */
     @Test
     public void pmx() {
        PMX p; 
        p=new PMX();
        int index1=3;
        int index2=6;
        int []x={1,2,3,4,5,6,7,8,9};
        int []y={9,3,7,8,2,6,5,1,4};
        int []expected={9,3,2,4,5,6,7,1,8};
        int []z;
        z=p.pmx(x,y,index1,index2);
        assertEquals(9,z.length);
        assertEquals(4,z[index1]);
        assertEquals(5,z[index1+1]);
        assertEquals(6,z[index1+2]);
        assertEquals(7,z[index1+3]);
         for (int i = 0; i < z.length; i++) {
             assertEquals(expected[i],z[i]);
         }
     }

    /**
     * Example taken from http://www.rubicite.com/Tutorials/GeneticAlgorithms/CrossoverOperators/PMXCrossoverOperator.aspx
     */

     @Test
     public void pmx2() {
        PMX p; 
        p=new PMX();
        
        // Parent 1: 8 4 7 3 6 2 5 1 9 0
        // Parent 2: 0 1 2 3 4 5 6 7 8 9
        // Child 1:  _ _ _ 3 6 2 5 1 _ _
        // expected result 0 7 4 3 6 2 5 1 8 9
        int index1=3;
        int index2=7;
        int []parent1={8,4,7,3,6,2,5,1,9,0};
        int []parent2= {0,1,2,3,4,5,6,7,8,9};
        int []expected={0,7,4,3,6,2,5,1,8,9};
        int []z;
        z=p.pmx(parent1,parent2,index1,index2);
        assertEquals(parent1.length,z.length);
         for (int i = 0; i < z.length; i++) {
             assertEquals(expected[i],z[i]);
         }
     }


}

