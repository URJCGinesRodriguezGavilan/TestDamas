package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Captor
    ArgumentCaptor<String> argument;

    @InjectMocks
    CommandView commandView;

    @Test
    public void testInteract(){
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString(argument.capture())).thenReturn("21.30\n");
        commandView.interact();
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

}