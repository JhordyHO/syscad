/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cad.interfaces;

import java.util.List;

/**
 *
 * @author UPEU
 * @param <Entidad>
 */
public interface Operaciones<Entidad> {
    public int create(Entidad p);
    public int delete(int id);
    public int update(Entidad p);
    public Entidad buscar(int id);
    public List<Entidad> listar();
    
}
