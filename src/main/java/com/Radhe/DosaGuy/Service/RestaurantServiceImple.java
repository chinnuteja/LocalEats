package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.Request.createRestaurantRequest;
import com.Radhe.DosaGuy.dto.RestaurantDto;
import com.Radhe.DosaGuy.model.Address;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.model.User;
import com.Radhe.DosaGuy.repository.AddressRepo;
import com.Radhe.DosaGuy.repository.RestaurantRepo;
import com.Radhe.DosaGuy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImple implements RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public Restaurant createRestaurant(createRestaurantRequest request, User user) {
        Address address=addressRepo.save(request.getAddress());
        Restaurant restaurant=new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(request.getPhone());
        restaurant.setDescription(request.getDescription());
        restaurant.setName(request.getName());
        restaurant.setOpeningHours(request.getOpeningTime());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);
        return restaurantRepo.save(restaurant);


    }

    @Override
    public Restaurant updateRestaurant(Long restaurantid, createRestaurantRequest request) throws Exception {
        Restaurant restaurant=getRestaurantById(restaurantid);
        if(restaurant.getDescription()!=null){
            restaurant.setDescription(request.getDescription());
        }
        if(restaurant.getName()!=null){
            restaurant.setName(request.getName());
        }
        if(restaurant.getOpeningHours()!=null){
            restaurant.setOpeningHours(request.getOpeningTime());
        }
        if(restaurant.getContactInformation()!=null){
            restaurant.setContactInformation(request.getPhone());
        }


        return restaurantRepo.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantid) throws Exception {

         Restaurant restaurant=getRestaurantById(restaurantid);
         restaurantRepo.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
       return restaurantRepo.findAll();

    }

    @Override
    public List<Restaurant> searchRestaurant(String Keyword) {
        return restaurantRepo.findBySearchQuery(Keyword);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantid) throws Exception {
        Optional<Restaurant> restaurant=restaurantRepo.findById(restaurantid);
        if(restaurant.isEmpty()){
            throw new Exception("Restaurant not found");
        }
        return restaurant.get();
    }

    @Override
    public Restaurant getRestaurantByUser(Long userid) throws Exception {
        Restaurant restaurant=restaurantRepo.findByOwner_Id(userid);
        if(restaurant==null){
            throw new Exception("Restaurant not found"+userid);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addtoFavourite(Long restaurantid, User user) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantid);
        RestaurantDto dto = new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantid);
//        if (user.getFavourite().contains(dto)) {
//            user.getFavourite().remove(dto);
//
//        }
//        else {
//            user.getFavourite().add(dto);
//        }

        boolean isFavourite=false;
        List<RestaurantDto> favourite=user.getFavourite();
        for(RestaurantDto r:favourite){
            if(r.getId()==restaurantid){
                isFavourite=true;
                break;
            }
        }
        if(isFavourite){
            user.getFavourite().remove(dto);
        }
        else {
            user.getFavourite().add(dto);
        }
        userRepo.save(user);
        return dto;
    }



    @Override
    public Restaurant updateRestaurantStatus(Long restaurantid) throws Exception {
        Restaurant restaurant = getRestaurantById(restaurantid);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepo.save(restaurant);
    }
}
