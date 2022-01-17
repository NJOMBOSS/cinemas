package org.sid.cinema.dao.service;

import org.sid.cinema.dao.modele.Cinema;
import org.sid.cinema.dao.modele.Place;
import org.sid.cinema.dao.modele.Salle;
import org.sid.cinema.dao.modele.Ville;
import org.sid.cinema.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service   //on utilise cette anotation parce que nous sommes sur la couche service
public class CinemaInitServiceImpl implements ICinemaInitService{
    @Autowired   // pour faire l'injection des dépendances
    private VilleRepository villeRepository;
    @Autowired   // pour faire l'injection des dépendances
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrakech","Rabat","Tanger").forEach(nomVille->{
            Ville ville=new Ville(); // instanciation de ville avec le constructeur sans parametre
            ville.setNom(nomVille);  // initialisaion de la ville
            villeRepository.save(ville); // enregistrement de la ville
        });

    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("MegaRama","IMAX","FOUNOUN","CHAHRAZAD","DOULIZ")
                    .forEach(nameCinema->{
                        Cinema cinema = new Cinema();
                        cinema.setName(nameCinema);
                        cinema.setNombreSalles(3+(int)(Math.random()*7));
                        cinema.setVille(v);
                        cinemaRepository.save(cinema);
                    });
        });

    }

    @Override
    public void initSalles() {

        cinemaRepository.findAll().forEach(cinema->{
            for(int i=0; i<cinema.getNombreSalles();i++){
                        Salle salle = new Salle();
                        salle.setNom("Salle"+(i+1));
                        salle.setCinema(cinema);
                        salle.setNombrePlace(15+(int)(Math.random()*20));
                        salleRepository.save(salle);

                    }
        });


    }

    @Override
    public void initPlaces() {

        salleRepository.findAll().forEach(salle->{
            for(int i=0; i< salle.getNombrePlace();i++){
                Place place = new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);

            }
        });

    }

    @Override
    public void initSeances() {

    }

    @Override
    public void initCategories() {

    }

    @Override
    public void initFilms() {

    }

    @Override
    public void initProjections() {

    }

    @Override
    public void initTickets() {

    }
}
