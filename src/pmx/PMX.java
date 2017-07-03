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
package pmx;

import java.util.Arrays;

/**
 * Class for the Partial Matching Crossover (PMX).
 * PMX is a crossover operator function for combinatorial optimization. It is specially useful for mixing permutaitions.
 * This implementation of PMX works for integer permutation from 1,..,n or 0,n-1.
 * @author César Astudillo <cesar dot astudillo at gmail dot com>
 */
public class PMX {

    /**
     * PMX crossover
     *
     * @param x first individual
     * @param y second individual
     * @param index1 index of the beginning of the crossover segment
     * @param index2 end of the crossover segment
     * @return
     */
    public int[] pmx(int[] x, int[] y, int index1, int index2) {

        boolean visited[] = new boolean[x.length+1]; //all false, are the node visited?

        int[] z = new int[x.length];//same dimensions as x
        for (int i = index1; i <= index2; i++) {
            z[i] = x[i];
            visited[z[i]] = true;
        }
        int k = index1;
        //Traverse parent2
        for (int i = index1; i <= index2; i++) { //para cada elemento del segmente

            if (!visited[y[i]]) {
                k = i;
                int elementToBeCopied = y[i]; //copiando el elemento desde la madre
                do {
                    int V = x[k];
                    //search in the mother ofr the index where the V is.
                    for (int j = 0; j < y.length; j++) {
                        if (y[j] == V) {
                            k = j;
                        }
                    }
                } while (z[k] != 0);
                z[k] = elementToBeCopied;
                visited[z[k]] = true;
            }
        }
        
        //copy the reminder elements from y
        
        for (int i = 0; i < z.length; i++) {
            if(z[i]==0)
                z[i]=y[i];
        }
        return z;
    }

}
