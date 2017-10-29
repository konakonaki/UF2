/*
 * Copyright (c) 2017, Mikl&oacute;s Cs&#369;r&ouml;s
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package unionfind;

/**
 *
 * @author Mikl&oacute;s Cs&#369;r&ouml;s, modifications by Stephanie Guay-Vachon and Michel Leblanc
 * 
 */
public class UnionFind 
{
    private int[] parent;
    private int[] size;
    private int counter;
    
    public UnionFind(int n)
    {
        this.parent = new int[n]; //Initialisation du tableau parent
        this.size = new int[n]; //Listes d'adjacence
        for (int i=0; i<n; i++)
        {
            parent[i] = i; // Classement des points (1, 2, 3, 4....)
            size[i]=1; //Degré de ces noeuds, même long que parents
        }
        this.counter = 0; //initialisation counter
    }
    public void counterAdd() {
        System.out.println("ajout compteur......");
    	this.counter++;
    }
    public int counterReturn() {

        System.out.println("cas retour du compteur...");
    	return this.counter;
    }
    
    /**
     * Union avec taille du résultat retourné.
     * 
     * @param x
     * @param y
     * @return taille après fusion
     */
    public int union(int x, int y)
    {
        int p = find(x); //Chercher la racine première du mini-arbre s'il y a lieu. Si ca retourne lui-même, arrêt de la recherche
        int q = find(y);
        if (p!=q) //Si les parents de x et y ne sont pas le même (alias, pts pas connectés)
        {
            int s = size[p]+size[q]; //Retourne taille de p et q (2 sous-arbres)
            System.out.println("cas p!=q");
            if(size[p]>size[q]) {
            	parent[q] = p;
            }
            else if (size[q]>size[p]) {
            	parent[p]=q;
            }
            else {
            	parent[q]=p;
            	size[p]++;
            }
            return s;  //Retourne la taille de tous tab unis. Si égal à n (n étant le nbr de points initialisé), END AND RETURN
        }
        this.counterAdd();
        System.out.println("cas p=q");
        return 0; //Si p==q, alors liés
    }
    
    public int find(int x)
    {
        int a = parent[x];
        if(x==a) {
            System.out.println("cas find: x=a");
        	return x;

        }
        System.out.println("cas x!=a dans find");
        return parent[x] = find(a);
    }
}