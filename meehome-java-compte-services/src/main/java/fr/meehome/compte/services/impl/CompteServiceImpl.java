package fr.meehome.compte.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.meehome.compte.dao.ICompteDao;
import fr.meehome.compte.dao.domain.Compte;
import fr.meehome.compte.services.ICompteService;
import fr.meehome.compte.services.dto.CompteDto;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

    @Autowired
    private ICompteDao compteDao;

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper mapper;

    private List<CompteDto> populate(List<Compte> list) {
        List<CompteDto> listCompteDto = new ArrayList<CompteDto>();
        for (Compte compte : list) {
            listCompteDto.add(mapper.map(compte, CompteDto.class));
        }
        return listCompteDto;
    }

    @Override
    public List<CompteDto> getAll() {
        return populate(compteDao.findAll());
    }

    @Override
    public List<CompteDto> getByLibelle(String libelle) {
        return populate(compteDao.findByLibelle(libelle));
    }

    @Override
    public boolean delete(List<CompteDto> list) {
        boolean result = false;
        for (CompteDto compteDto : list) {
            List<Compte> listCompteFind = compteDao.findByLibelle(compteDto.getLibelle());
            if (listCompteFind != null && !listCompteFind.isEmpty()) {
                for (Compte compte : listCompteFind) {
                    result = compteDao.remove(compte);
                }
            }
        }
        return result;
    }

    @Override
    public boolean add(List<CompteDto> list) {
        for (CompteDto compteDto : list) {
            compteDao.save(mapper.map(compteDto, Compte.class));
        }
        return false;
    }

    @Override
    public boolean update(List<CompteDto> list) {
        // TODO Auto-generated method stub
        return false;
    }

}
