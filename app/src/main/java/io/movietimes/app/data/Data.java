package io.movietimes.app.data;


import java.util.ArrayList;
import java.util.List;

import io.movietimes.app.model.Card;

public class Data {

    public static final String[] IMG_LIST = {
            "https://img3.doubanio.com/view/photo/l/public/p2514175916.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2511355624.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2509643816.webp",
            "https://img1.doubanio.com/view/photo/l/public/p2510081688.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2514175916.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2511355624.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2509643816.webp",
            "https://img1.doubanio.com/view/photo/l/public/p2510081688.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2514175916.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2511355624.webp",
            "https://img3.doubanio.com/view/photo/l/public/p2509643816.webp",
            "https://img1.doubanio.com/view/photo/l/public/p2510081688.webp"
    };

    public static final String[] TITLE_LIST = {
            "Operation Red Sea",
            "Detective Chinatown Vol 2",
            "Monster Hunt 2",
            "Three Billboards Outside Ebbing, Missouri",
            "Operation Red Sea",
            "Detective Chinatown Vol 2",
            "Monster Hunt 2",
            "Three Billboards Outside Ebbing, Missouri",
            "Operation Red Sea",
            "Detective Chinatown Vol 2",
            "Monster Hunt 2",
            "Three Billboards Outside Ebbing, Missouri"
    };

    public static List<Card> genCardList(){
        List<Card> cardList = new ArrayList<>();
        Card card;
        for (int i = 0; i < 12; i++) {
            card = new Card();
            card.setImg(IMG_LIST[i]);
            card.setTitle(TITLE_LIST[i]);
            cardList.add(card);
        }
        return cardList;
    }
}
