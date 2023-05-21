package hu.nye.progkor.gamecatalog.service.impl;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.data.model.Genre;
import hu.nye.progkor.gamecatalog.data.repository.Repository;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Unit test for {@link DefaultGameService}
 */
class DefaultGameServiceTest {

    private static final Long DUMMY_GAME_ID = 1L;
    private static final Game DUMMY_GAME = new Game(DUMMY_GAME_ID, "title",1999, "publisher","studio", Genre.ACTION ,121, 1024);

    @Mock
    private Repository<Game, Long> gameRepository;
    private GameService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultGameService(gameRepository);
    }

    @Test
    void createGameShouldDelegateToTheRepositoryAndReturnSavedGame() {
        // Given
        given(gameRepository.save(DUMMY_GAME)).willReturn(DUMMY_GAME);

        // When
        final Game actual = underTest.createGame(DUMMY_GAME);

        //Then
        assertThat(actual, equalTo(DUMMY_GAME));
        verify(gameRepository).save(DUMMY_GAME);
        verifyNoMoreInteractions(gameRepository);

    }

    @Test
    void retrieveGameById() {
        //Given
        given(gameRepository.getById(DUMMY_GAME_ID)).willReturn(DUMMY_GAME);
        //When
        final Game actual = underTest.retrieveGameById(DUMMY_GAME_ID);
        //Then
        assertThat(actual, equalTo(DUMMY_GAME));
        verify(gameRepository).getById(DUMMY_GAME_ID);
        verifyNoMoreInteractions(gameRepository);

    }

    @Test
    void retrieveAllGame() {
        //Given
        given(gameRepository.getAll()).willReturn(List.of(DUMMY_GAME));
        //When
        final List<Game> actual = underTest.retrieveAllGames();
        //Then
        assertThat(actual, equalTo(List.of(DUMMY_GAME)));
        verify(gameRepository).getAll();
        verifyNoMoreInteractions(gameRepository);
    }

    @Test
    void updateGame() {
    }

    @Test
    void deleteGameByID() {
    }
}