package tests;

import org.testng.annotations.Test;

public class OnlineCinemaTest extends BaseTest{
    @Test
    public void filmSelection(){
        onlineCinemaPage.openPage("https://www.tut.by/")
                         .onlineCinema()
                         .choiceOfGenre("Фантастика");

    }
    @Test
    public void seriesSelection(){
        onlineCinemaPage.openPage("https://afisha.tut.by/online-cinema/")
                         .categorySelection("Сериалы")
                         .choiceOfGenre("Комедия");
    }
    @Test
    public void cartoonsSelection(){
        onlineCinemaPage.openPage("https://afisha.tut.by/online-cinema/animation/")
                         .choiceOfGenre("Фэнтези");
    }
}
