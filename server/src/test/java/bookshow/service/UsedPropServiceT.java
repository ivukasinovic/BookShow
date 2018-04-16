package bookshow.service;

import bookshow.domain.props.UsedProp;
import bookshow.domain.props.UsedPropStatus;
import bookshow.domain.users.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan V. on 16-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsedPropServiceT {

    @Autowired
    UsedPropService usedPropService;
    @Autowired
    UserService userService;

    @Test
    public void testCreateUsedProp(){
        String username = "milan";
        UsedProp usedProp = new UsedProp();
        usedProp.setTitle("test titleUP");
        usedProp.setDescription("test descriptionUP");
        usedProp.setImage("image.image.image");
        Date date = new Date(2019, 6, 20, 4, 0);
        usedProp.setActiveUntil(date);
        usedPropService.createUsedProp(username,usedProp);

        UsedProp newUsedProp = usedPropService.findOne(5L);
        assertThat(newUsedProp).isNotNull();
        assertEquals(newUsedProp.getTitle(),usedProp.getTitle());
        assertEquals(newUsedProp.getDescription(),usedProp.getDescription());
        assertEquals(newUsedProp.getImage(),usedProp.getImage());

    }

    @Test
    @Transactional
    public void testAcceptBid() {
        Long usedPropId = 2L;
        Long acceptedBidId = 2L;
        usedPropService.acceptBid(usedPropId, acceptedBidId);
        UsedProp acceptedUsedProp = usedPropService.findOne(2L);

        assertEquals(acceptedUsedProp.getAcceptedBid(),acceptedBidId);
    }

    @Test
    public void approveDecline(){
        Long usedPropId = 1L;
        String type="approve";
        User adminFan = userService.findOne(1L);
        try {
            usedPropService.approveDecline(usedPropId,type,adminFan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UsedProp usedProp = usedPropService.findOne(1L);
        assertEquals(usedProp.getStatus(), UsedPropStatus.APPROVED);

    }
}
