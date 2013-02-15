package fr.meehome.compte.services;

import java.util.List;

import fr.meehome.compte.services.dto.CompteDto;

public interface ICompteService {

    public List<CompteDto> getAll();

    public List<CompteDto> getByLibelle(String libelle);

    public boolean delete(List<CompteDto> list);

    public boolean add(List<CompteDto> list);

    public boolean update(List<CompteDto> list);

}
