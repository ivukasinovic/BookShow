package bookshow.service;

import bookshow.domain.props.NewProp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static bookshow.constraints.NewPropConstraints.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Ivan V. on 16-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewPropServiceT {

    @Autowired
    NewPropService newPropService;
    @Autowired
    UserService userService;
    @Autowired
    ShowService showService;

    @Test
    public void testFindAll(){
        assertEquals(2, newPropService.findAll().size());
    }

    @Test
    public void testFindOne(){
        NewProp newProp = newPropService.findOne(NP_ID);
        assertThat(newProp).isNotNull();

        assertThat(newProp.getId()).isEqualTo(NP_ID);
        assertThat(newProp.getPrice()).isEqualTo(NP_PRICE);
        assertThat(newProp.getTitle()).isEqualTo(NP_TITLE);
        assertThat(newProp.getDescription()).isEqualTo(NP_DESCRIPTION);
        assertThat(newProp.getImage()).isEqualTo(NP_IMAGE);
    }

    @Test
    public void testSave(){
        NewProp newProp = new NewProp();
        newProp.setTitle("Test prop");
        newProp.setDescription("Description of new prop");
        newProp.setImage("image.image.image");
        newProp.setDateCreated(new java.util.Date());
        newProp.setPrice(1450);
        newProp.setFanAdmin(userService.findOne(1L));
        newProp.setShow(showService.findOne(1L));
        newProp.setUser(userService.findOne(5L));

        NewProp savedNewProp = newPropService.save(newProp);
        NewProp loadedNewProp = newPropService.findOne(savedNewProp.getId());

        assertThat(savedNewProp).isNotNull();
        assertThat(loadedNewProp).isNotNull();
        assertEquals(loadedNewProp.getId(),savedNewProp.getId());
    }
    @Test
    public void testDelete(){
        NewProp newProp = new NewProp();
        newProp.setTitle("Test prop");
        newProp.setDescription("Description of new prop");
        newProp.setImage("image.image.image");
        newProp.setDateCreated(new java.util.Date());
        newProp.setPrice(1450);
        newProp.setFanAdmin(userService.findOne(1L));
        newProp.setShow(showService.findOne(1L));
        newProp.setUser(userService.findOne(5L));

        NewProp savedNewProp = newPropService.save(newProp);
        newPropService.delete(savedNewProp.getId());
        NewProp loadedNewProp = newPropService.findOne(savedNewProp.getId());
        assertNull(loadedNewProp);

    }
}
