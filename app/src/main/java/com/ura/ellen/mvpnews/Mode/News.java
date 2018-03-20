package com.ura.ellen.mvpnews.Mode;

import com.ura.ellen.mvpnews.BaseApplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

public class News {


    /**
     * data : {"bigImg":[{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"习近平出席十三届全国人大一次会议解放军和武警部队代表团全体会议","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520851260000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852137463_387_640x360.jpg","commentNum":"","itemID":"Arti7GyqJ3obGk59W451TP1R180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti7GyqJ3obGk59W451TP1R180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:41:00"},{"brief":"","itemBrief":"","allow_share":"0","itemType":"ad_url_flag","videoLength":"","itemTitle":"两会号外雄安篇丨微视频《从深圳到雄安》","tagColor":"","allow_comment":"0","num":"","templetType":"0","imageNum":"1","pubDate":"1520819037000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520818993651_649_640x360.jpg","commentNum":"","itemID":"ArtivVwvXgfQwpgYrnkO8QXb180312","allow_praise":"0","videoPlayID":"","detailUrl":"http://webapp.cctv.com/h5/m_news/U90311M6BEV9B9U4.html?1=1","itemType_VR":"0","operate_time":"2018-03-12 09:43:57"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520815511000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520818366407_376_640x360.jpg","commentNum":"","itemID":"ArtiyoGnMoIDAmjgBE3bATxu180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiyoGnMoIDAmjgBE3bATxu180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 08:45:11"}],"listUrl":"http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataListInfoNew?id=Nav-9Nwml0dIB6wAxgd9EfZA160510&toutuNum=3&version=1","itemList":[{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:25","itemTitle":"习近平的\u201c下团组\u201d时间 | 六下团组频问计 一枝一叶总关情","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520857940000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"},"commentNum":"","itemID":"ArtiBbm2tmoHdGsyp5RBcsQr180312","allow_praise":"1","videoPlayID":"4e75c45c5bf6489b5ec5fbc8c7687708","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBbm2tmoHdGsyp5RBcsQr180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 20:32:20"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:52","itemTitle":"【V观】习近平出席解放军和武警部队代表团全体会议","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852940000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852904610_858_538x404.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852904610_858_538x404.png"},"commentNum":"","itemID":"Arti4Vur7GbuaPOJ4ZIeHrHt180312","allow_praise":"1","videoPlayID":"79f043e1b1043b81c0a77d4fa53b77e2","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti4Vur7GbuaPOJ4ZIeHrHt180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:09:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:07","itemTitle":"【V观】习近平：仗怎么打，就怎么练","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520853780000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520853617936_468_403x302.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520855184302_785_400x300.jpg"},"commentNum":"","itemID":"ArtiXodMlzx03JtZ6eF1IVh3180312","allow_praise":"1","videoPlayID":"0a31d8667330288d5025891fc01a4205","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiXodMlzx03JtZ6eF1IVh3180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:23:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:53","itemTitle":"【V观】习近平：士官队伍是部队中非常基础的骨干力量","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520854507000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854240245_631_375x281.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854240245_631_375x281.png"},"commentNum":"","itemID":"Artih51ePljVxGWibAgvWRi5180312","allow_praise":"1","videoPlayID":"92bdb0c1d7cb6a413783a97c878cdf5a","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Artih51ePljVxGWibAgvWRi5180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:35:07"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:41","itemTitle":"【V观】习近平：不要让英雄既流血又流泪","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520854478000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854145042_3_509x382.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854145042_3_509x382.png"},"commentNum":"","itemID":"ArtiXPKJUtPQVCSJQ1e1swJR180312","allow_praise":"1","videoPlayID":"1668be483fbf3fc5eba2d4830e9ec4e9","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiXPKJUtPQVCSJQ1e1swJR180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:34:38"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:04","itemTitle":"深化党和国家机构改革备受瞩目 中办主任丁薛祥撰文解读","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520834100000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520834028534_310_770x578.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520834028534_310_770x578.png"},"commentNum":"","itemID":"Artivoj4j5XJom34IfRURe2Q180312","allow_praise":"1","videoPlayID":"f6b015e9304f4599bd7401a7ebee5c39","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Artivoj4j5XJom34IfRURe2Q180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 13:55:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"外交部长王毅：努力开辟朝鲜半岛新的未来","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520862684000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520862632387_272_400x300.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520862632387_272_400x300.jpg"},"commentNum":"","itemID":"ArticZB6wkb9SRb2nFG7dChM180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticZB6wkb9SRb2nFG7dChM180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 21:51:24"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:32","itemTitle":"持续关注丨我驻尼泊尔使馆：失事航班中国公民伤亡情况不详","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520846880000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520847400046_462_598x449.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520847400046_462_598x449.jpg"},"commentNum":"","itemID":"ArtijPDKmWnGZUJaFKr1U5A2180312","allow_praise":"1","videoPlayID":"3d84da7105f04256931722fa17d83e9c","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtijPDKmWnGZUJaFKr1U5A2180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 17:28:00"},{"brief":"","itemBrief":"","allow_share":"","itemType":"classtopic_flag","videoLength":"","itemTitle":"更好发挥宪法治国安邦总章程作用","tagColor":"","allow_comment":"","num":"","templetType":"0","imageNum":"1","pubDate":"1520842011000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520841989439_943_640x128.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520841989439_943_640x128.png"},"commentNum":"","itemID":"SpecJ05GJMqdKdHDiIEFE2T9180312","allow_praise":"","videoPlayID":"","detailUrl":"http://api.cportal.cctv.com/api/rest/specialList/getTopicblock?id=SpecJ05GJMqdKdHDiIEFE2T9180312","itemType_VR":"0","operate_time":"2018-03-12 16:06:51"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"外交部：愿中印关系沿正确轨道发展","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520844886000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844753702_110_442x331.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844753702_110_442x331.jpg"},"commentNum":"","itemID":"Arti6ZLjc1EcnIFMcAVuH1IS180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti6ZLjc1EcnIFMcAVuH1IS180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:54:46"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:49","itemTitle":"外交部：应客观公正看待菲禁毒反恐成果","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520845034000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844923087_197_388x291.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844923087_197_388x291.jpg"},"commentNum":"","itemID":"ArtimGHuYC7Q2olSB3MfAQue180312","allow_praise":"1","videoPlayID":"cb4ffbb1e8c4461c984e2510da2ca301","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtimGHuYC7Q2olSB3MfAQue180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:57:14"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"2018年楼市怎么走？多部委两会密集表态，了解一下→","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852212000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520848779423_108_951x714.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520848779423_108_951x714.jpg"},"commentNum":"","itemID":"ArtiD5efpk3qMlpsO5Ky5MKZ180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiD5efpk3qMlpsO5Ky5MKZ180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:56:52"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"40:38","itemTitle":"敬！一边开两会一边做手术 这位仁医的朋友圈向所有病人开放","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520850518000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520850506804_662_819x614.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520850506804_662_819x614.jpg"},"commentNum":"","itemID":"ArticjtXN8gvhduA3BNKoYST180312","allow_praise":"1","videoPlayID":"c4a1d20d75f74f3f8413b4c95a0989e4","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticjtXN8gvhduA3BNKoYST180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:28:38"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:05","itemTitle":"暖！两名工人被垮塌泥土掩埋，50多名路过武警徒手挖人","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852229000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520849255060_95_665x499.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520849255060_95_665x499.jpg"},"commentNum":"","itemID":"ArticMyCqPMN4aAEABawnqb0180312","allow_praise":"1","videoPlayID":"6896b8e3d4f847798981543bb9e9a211","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticMyCqPMN4aAEABawnqb0180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:57:09"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"@所有人，这20个领域今年将有大动作！了解一下","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520825382000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520824439343_290_954x716.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520824439343_290_954x716.jpg"},"commentNum":"","itemID":"ArtiWyyZ7IhaDWiPJVxbYoab180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiWyyZ7IhaDWiPJVxbYoab180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 11:29:42"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:39","itemTitle":"【微视频】吴恒：修订《红十字会法》主要体现了三个方面","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520832935000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520832008979_474_552x414.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520832008979_474_552x414.png"},"commentNum":"","itemID":"ArtiesC8lwKjpexv9IXRHhMJ180312","allow_praise":"1","videoPlayID":"d70597edf79c42beaaf19ddb2d868c33","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiesC8lwKjpexv9IXRHhMJ180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 13:35:35"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:43","itemTitle":"【微视频】袁驷：我们全面修改了《环境保护法》 这个法是带\u201c牙齿\u201d的","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520846309000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520846280602_874_517x388.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520846280602_874_517x388.png"},"commentNum":"","itemID":"ArtiBBHnkuzjZyInxwdIIXxo180312","allow_praise":"1","videoPlayID":"191244945746493b9905c8c145cf08fb","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBBHnkuzjZyInxwdIIXxo180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 17:18:29"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"04:30","itemTitle":"【微视频】郑功成：网络安全执法检查首次引入第三方参与","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520845028000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844420329_948_718x538.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844420329_948_718x538.jpg"},"commentNum":"","itemID":"ArtiBlLC8vot9bIcjAgqgagX180312","allow_praise":"0","videoPlayID":"e9812850b855458c88d0576902e3ac82","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBlLC8vot9bIcjAgqgagX180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:57:08"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"02:40","itemTitle":"【微视频】刘修文：人大审查向支出预算和政策拓展 意义重大深远","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520843326000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520842834833_194_548x411.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520842834833_194_548x411.png"},"commentNum":"","itemID":"ArtirMAQt0r9oxdV5dLriC0a180312","allow_praise":"1","videoPlayID":"7b4b9cbc00384641a039b0787e6a52b6","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtirMAQt0r9oxdV5dLriC0a180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:28:46"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:31","itemTitle":"【微视频】王胜明：《监察法》通过后《检察院组织法》等法将相应修改","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520824010000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520823857384_414_718x538.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520823857384_414_718x538.jpg"},"commentNum":"","itemID":"Arti2YTS8YNREsee5yiPje21180312","allow_praise":"1","videoPlayID":"f2e03d8a48f04975931ea40314642e99","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti2YTS8YNREsee5yiPje21180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 11:06:50"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean {
        /**
         * bigImg : [{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"习近平出席十三届全国人大一次会议解放军和武警部队代表团全体会议","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520851260000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852137463_387_640x360.jpg","commentNum":"","itemID":"Arti7GyqJ3obGk59W451TP1R180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti7GyqJ3obGk59W451TP1R180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:41:00"},{"brief":"","itemBrief":"","allow_share":"0","itemType":"ad_url_flag","videoLength":"","itemTitle":"两会号外雄安篇丨微视频《从深圳到雄安》","tagColor":"","allow_comment":"0","num":"","templetType":"0","imageNum":"1","pubDate":"1520819037000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520818993651_649_640x360.jpg","commentNum":"","itemID":"ArtivVwvXgfQwpgYrnkO8QXb180312","allow_praise":"0","videoPlayID":"","detailUrl":"http://webapp.cctv.com/h5/m_news/U90311M6BEV9B9U4.html?1=1","itemType_VR":"0","operate_time":"2018-03-12 09:43:57"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520815511000","tagDesc":"","photoCount":"","itemImage":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520818366407_376_640x360.jpg","commentNum":"","itemID":"ArtiyoGnMoIDAmjgBE3bATxu180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiyoGnMoIDAmjgBE3bATxu180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 08:45:11"}]
         * listUrl : http://api.cportal.cctv.com/api/rest/navListInfo/getHandDataListInfoNew?id=Nav-9Nwml0dIB6wAxgd9EfZA160510&toutuNum=3&version=1
         * itemList : [{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:25","itemTitle":"习近平的\u201c下团组\u201d时间 | 六下团组频问计 一枝一叶总关情","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520857940000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"},"commentNum":"","itemID":"ArtiBbm2tmoHdGsyp5RBcsQr180312","allow_praise":"1","videoPlayID":"4e75c45c5bf6489b5ec5fbc8c7687708","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBbm2tmoHdGsyp5RBcsQr180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 20:32:20"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:52","itemTitle":"【V观】习近平出席解放军和武警部队代表团全体会议","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852940000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852904610_858_538x404.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852904610_858_538x404.png"},"commentNum":"","itemID":"Arti4Vur7GbuaPOJ4ZIeHrHt180312","allow_praise":"1","videoPlayID":"79f043e1b1043b81c0a77d4fa53b77e2","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti4Vur7GbuaPOJ4ZIeHrHt180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:09:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:07","itemTitle":"【V观】习近平：仗怎么打，就怎么练","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520853780000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520853617936_468_403x302.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520855184302_785_400x300.jpg"},"commentNum":"","itemID":"ArtiXodMlzx03JtZ6eF1IVh3180312","allow_praise":"1","videoPlayID":"0a31d8667330288d5025891fc01a4205","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiXodMlzx03JtZ6eF1IVh3180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:23:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:53","itemTitle":"【V观】习近平：士官队伍是部队中非常基础的骨干力量","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520854507000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854240245_631_375x281.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854240245_631_375x281.png"},"commentNum":"","itemID":"Artih51ePljVxGWibAgvWRi5180312","allow_praise":"1","videoPlayID":"92bdb0c1d7cb6a413783a97c878cdf5a","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Artih51ePljVxGWibAgvWRi5180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:35:07"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:41","itemTitle":"【V观】习近平：不要让英雄既流血又流泪","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520854478000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854145042_3_509x382.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520854145042_3_509x382.png"},"commentNum":"","itemID":"ArtiXPKJUtPQVCSJQ1e1swJR180312","allow_praise":"1","videoPlayID":"1668be483fbf3fc5eba2d4830e9ec4e9","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiXPKJUtPQVCSJQ1e1swJR180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 19:34:38"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:04","itemTitle":"深化党和国家机构改革备受瞩目 中办主任丁薛祥撰文解读","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520834100000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520834028534_310_770x578.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520834028534_310_770x578.png"},"commentNum":"","itemID":"Artivoj4j5XJom34IfRURe2Q180312","allow_praise":"1","videoPlayID":"f6b015e9304f4599bd7401a7ebee5c39","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Artivoj4j5XJom34IfRURe2Q180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 13:55:00"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"外交部长王毅：努力开辟朝鲜半岛新的未来","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520862684000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520862632387_272_400x300.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520862632387_272_400x300.jpg"},"commentNum":"","itemID":"ArticZB6wkb9SRb2nFG7dChM180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticZB6wkb9SRb2nFG7dChM180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 21:51:24"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"00:32","itemTitle":"持续关注丨我驻尼泊尔使馆：失事航班中国公民伤亡情况不详","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520846880000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520847400046_462_598x449.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520847400046_462_598x449.jpg"},"commentNum":"","itemID":"ArtijPDKmWnGZUJaFKr1U5A2180312","allow_praise":"1","videoPlayID":"3d84da7105f04256931722fa17d83e9c","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtijPDKmWnGZUJaFKr1U5A2180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 17:28:00"},{"brief":"","itemBrief":"","allow_share":"","itemType":"classtopic_flag","videoLength":"","itemTitle":"更好发挥宪法治国安邦总章程作用","tagColor":"","allow_comment":"","num":"","templetType":"0","imageNum":"1","pubDate":"1520842011000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520841989439_943_640x128.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520841989439_943_640x128.png"},"commentNum":"","itemID":"SpecJ05GJMqdKdHDiIEFE2T9180312","allow_praise":"","videoPlayID":"","detailUrl":"http://api.cportal.cctv.com/api/rest/specialList/getTopicblock?id=SpecJ05GJMqdKdHDiIEFE2T9180312","itemType_VR":"0","operate_time":"2018-03-12 16:06:51"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"外交部：愿中印关系沿正确轨道发展","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520844886000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844753702_110_442x331.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844753702_110_442x331.jpg"},"commentNum":"","itemID":"Arti6ZLjc1EcnIFMcAVuH1IS180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti6ZLjc1EcnIFMcAVuH1IS180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:54:46"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:49","itemTitle":"外交部：应客观公正看待菲禁毒反恐成果","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520845034000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844923087_197_388x291.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844923087_197_388x291.jpg"},"commentNum":"","itemID":"ArtimGHuYC7Q2olSB3MfAQue180312","allow_praise":"1","videoPlayID":"cb4ffbb1e8c4461c984e2510da2ca301","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtimGHuYC7Q2olSB3MfAQue180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:57:14"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"2018年楼市怎么走？多部委两会密集表态，了解一下→","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852212000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520848779423_108_951x714.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520848779423_108_951x714.jpg"},"commentNum":"","itemID":"ArtiD5efpk3qMlpsO5Ky5MKZ180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiD5efpk3qMlpsO5Ky5MKZ180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:56:52"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"40:38","itemTitle":"敬！一边开两会一边做手术 这位仁医的朋友圈向所有病人开放","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520850518000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520850506804_662_819x614.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520850506804_662_819x614.jpg"},"commentNum":"","itemID":"ArticjtXN8gvhduA3BNKoYST180312","allow_praise":"1","videoPlayID":"c4a1d20d75f74f3f8413b4c95a0989e4","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticjtXN8gvhduA3BNKoYST180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:28:38"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:05","itemTitle":"暖！两名工人被垮塌泥土掩埋，50多名路过武警徒手挖人","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520852229000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520849255060_95_665x499.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520849255060_95_665x499.jpg"},"commentNum":"","itemID":"ArticMyCqPMN4aAEABawnqb0180312","allow_praise":"1","videoPlayID":"6896b8e3d4f847798981543bb9e9a211","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArticMyCqPMN4aAEABawnqb0180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 18:57:09"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"","itemTitle":"@所有人，这20个领域今年将有大动作！了解一下","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520825382000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520824439343_290_954x716.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520824439343_290_954x716.jpg"},"commentNum":"","itemID":"ArtiWyyZ7IhaDWiPJVxbYoab180312","allow_praise":"1","videoPlayID":"","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiWyyZ7IhaDWiPJVxbYoab180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 11:29:42"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:39","itemTitle":"【微视频】吴恒：修订《红十字会法》主要体现了三个方面","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520832935000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520832008979_474_552x414.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520832008979_474_552x414.png"},"commentNum":"","itemID":"ArtiesC8lwKjpexv9IXRHhMJ180312","allow_praise":"1","videoPlayID":"d70597edf79c42beaaf19ddb2d868c33","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiesC8lwKjpexv9IXRHhMJ180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 13:35:35"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"03:43","itemTitle":"【微视频】袁驷：我们全面修改了《环境保护法》 这个法是带\u201c牙齿\u201d的","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520846309000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520846280602_874_517x388.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520846280602_874_517x388.png"},"commentNum":"","itemID":"ArtiBBHnkuzjZyInxwdIIXxo180312","allow_praise":"1","videoPlayID":"191244945746493b9905c8c145cf08fb","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBBHnkuzjZyInxwdIIXxo180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 17:18:29"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"04:30","itemTitle":"【微视频】郑功成：网络安全执法检查首次引入第三方参与","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520845028000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844420329_948_718x538.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520844420329_948_718x538.jpg"},"commentNum":"","itemID":"ArtiBlLC8vot9bIcjAgqgagX180312","allow_praise":"0","videoPlayID":"e9812850b855458c88d0576902e3ac82","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBlLC8vot9bIcjAgqgagX180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:57:08"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"02:40","itemTitle":"【微视频】刘修文：人大审查向支出预算和政策拓展 意义重大深远","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520843326000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520842834833_194_548x411.png"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520842834833_194_548x411.png"},"commentNum":"","itemID":"ArtirMAQt0r9oxdV5dLriC0a180312","allow_praise":"1","videoPlayID":"7b4b9cbc00384641a039b0787e6a52b6","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtirMAQt0r9oxdV5dLriC0a180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 16:28:46"},{"brief":"","itemBrief":"","allow_share":"1","itemType":"article_flag","videoLength":"01:31","itemTitle":"【微视频】王胜明：《监察法》通过后《检察院组织法》等法将相应修改","tagColor":"","allow_comment":"1","num":"","templetType":"0","imageNum":"1","pubDate":"1520824010000","scrollImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520823857384_414_718x538.jpg"},"tagDesc":"","photoCount":"","itemImage":{"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520823857384_414_718x538.jpg"},"commentNum":"","itemID":"Arti2YTS8YNREsee5yiPje21180312","allow_praise":"1","videoPlayID":"f2e03d8a48f04975931ea40314642e99","detailUrl":"http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti2YTS8YNREsee5yiPje21180312&isfromapp=1","itemType_VR":"0","operate_time":"2018-03-12 11:06:50"}]
         */

        private String listUrl;
        private List<BigImgBean> bigImg;
        private List<ItemListBean> itemList;

        public String getListUrl() {
            return listUrl;
        }

        public void setListUrl(String listUrl) {
            this.listUrl = listUrl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        @Entity
        public static class BigImgBean {
            /**
             * brief :
             * itemBrief :
             * allow_share : 1
             * itemType : article_flag
             * videoLength :
             * itemTitle : 习近平出席十三届全国人大一次会议解放军和武警部队代表团全体会议
             * tagColor :
             * allow_comment : 1
             * num :
             * templetType : 0
             * imageNum : 1
             * pubDate : 1520851260000
             * tagDesc :
             * photoCount :
             * itemImage : http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520852137463_387_640x360.jpg
             * commentNum :
             * itemID : Arti7GyqJ3obGk59W451TP1R180312
             * allow_praise : 1
             * videoPlayID :
             * detailUrl : http://app.cntv.cn/special/cportal/detail/arti/index.html?id=Arti7GyqJ3obGk59W451TP1R180312&isfromapp=1
             * itemType_VR : 0
             * operate_time : 2018-03-12 18:41:00
             */

            //不能用int
            @Id(autoincrement = true)
            private Long ID;
            private String brief;
            private String itemBrief;
            private String allow_share;
            private String itemType;
            private String videoLength;
            private String itemTitle;
            private String tagColor;
            private String allow_comment;
            private String num;
            private String templetType;
            private String imageNum;
            private String pubDate;
            private String tagDesc;
            private String photoCount;
            private String itemImage;
            private String commentNum;
            private String itemID;
            private String allow_praise;
            private String videoPlayID;
            private String detailUrl;
            private String itemType_VR;
            private String operate_time;

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getItemBrief() {
                return itemBrief;
            }

            public void setItemBrief(String itemBrief) {
                this.itemBrief = itemBrief;
            }

            public String getAllow_share() {
                return allow_share;
            }

            public void setAllow_share(String allow_share) {
                this.allow_share = allow_share;
            }

            public String getItemType() {
                return itemType;
            }

            public void setItemType(String itemType) {
                this.itemType = itemType;
            }

            public String getVideoLength() {
                return videoLength;
            }

            public void setVideoLength(String videoLength) {
                this.videoLength = videoLength;
            }

            public String getItemTitle() {
                return itemTitle;
            }

            public void setItemTitle(String itemTitle) {
                this.itemTitle = itemTitle;
            }

            public String getTagColor() {
                return tagColor;
            }

            public void setTagColor(String tagColor) {
                this.tagColor = tagColor;
            }

            public String getAllow_comment() {
                return allow_comment;
            }

            public void setAllow_comment(String allow_comment) {
                this.allow_comment = allow_comment;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getTempletType() {
                return templetType;
            }

            public void setTempletType(String templetType) {
                this.templetType = templetType;
            }

            public String getImageNum() {
                return imageNum;
            }

            public void setImageNum(String imageNum) {
                this.imageNum = imageNum;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public String getTagDesc() {
                return tagDesc;
            }

            public void setTagDesc(String tagDesc) {
                this.tagDesc = tagDesc;
            }

            public String getPhotoCount() {
                return photoCount;
            }

            public void setPhotoCount(String photoCount) {
                this.photoCount = photoCount;
            }

            public String getItemImage() {
                return itemImage;
            }

            public void setItemImage(String itemImage) {
                this.itemImage = itemImage;
            }

            public String getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(String commentNum) {
                this.commentNum = commentNum;
            }

            public String getItemID() {
                return itemID;
            }

            public void setItemID(String itemID) {
                this.itemID = itemID;
            }

            public String getAllow_praise() {
                return allow_praise;
            }

            public void setAllow_praise(String allow_praise) {
                this.allow_praise = allow_praise;
            }

            public String getVideoPlayID() {
                return videoPlayID;
            }

            public void setVideoPlayID(String videoPlayID) {
                this.videoPlayID = videoPlayID;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getItemType_VR() {
                return itemType_VR;
            }

            public void setItemType_VR(String itemType_VR) {
                this.itemType_VR = itemType_VR;
            }

            public String getOperate_time() {
                return operate_time;
            }

            public void setOperate_time(String operate_time) {
                this.operate_time = operate_time;
            }
        }

        @Entity
        public static class ItemListBean {
            /**
             * brief :
             * itemBrief :
             * allow_share : 1
             * itemType : article_flag
             * videoLength : 03:25
             * itemTitle : 习近平的“下团组”时间 | 六下团组频问计 一枝一叶总关情
             * tagColor :
             * allow_comment : 1
             * num :
             * templetType : 0
             * imageNum : 1
             * pubDate : 1520857940000
             * scrollImage : {"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"}
             * tagDesc :
             * photoCount :
             * itemImage : {"imgUrl1":"http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg"}
             * commentNum :
             * itemID : ArtiBbm2tmoHdGsyp5RBcsQr180312
             * allow_praise : 1
             * videoPlayID : 4e75c45c5bf6489b5ec5fbc8c7687708
             * detailUrl : http://app.cntv.cn/special/cportal/detail/arti/index.html?id=ArtiBbm2tmoHdGsyp5RBcsQr180312&isfromapp=1
             * itemType_VR : 0
             * operate_time : 2018-03-12 20:32:20
             */

            //不能用int
            @Id(autoincrement = true)
            private Long ID;
            private String brief;
            private String itemBrief;
            private String allow_share;
            private String itemType;
            private String videoLength;
            private String itemTitle;
            private String tagColor;
            private String allow_comment;
            private String num;
            private String templetType;
            private String imageNum;
            private String pubDate;
            private ScrollImageBean scrollImage;
            private String tagDesc;
            private String photoCount;
            private ItemImageBean itemImage;
            private String commentNum;
            private String itemID;
            private String allow_praise;
            private String videoPlayID;
            private String detailUrl;
            private String itemType_VR;
            private String operate_time;

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getItemBrief() {
                return itemBrief;
            }

            public void setItemBrief(String itemBrief) {
                this.itemBrief = itemBrief;
            }

            public String getAllow_share() {
                return allow_share;
            }

            public void setAllow_share(String allow_share) {
                this.allow_share = allow_share;
            }

            public String getItemType() {
                return itemType;
            }

            public void setItemType(String itemType) {
                this.itemType = itemType;
            }

            public String getVideoLength() {
                return videoLength;
            }

            public void setVideoLength(String videoLength) {
                this.videoLength = videoLength;
            }

            public String getItemTitle() {
                return itemTitle;
            }

            public void setItemTitle(String itemTitle) {
                this.itemTitle = itemTitle;
            }

            public String getTagColor() {
                return tagColor;
            }

            public void setTagColor(String tagColor) {
                this.tagColor = tagColor;
            }

            public String getAllow_comment() {
                return allow_comment;
            }

            public void setAllow_comment(String allow_comment) {
                this.allow_comment = allow_comment;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getTempletType() {
                return templetType;
            }

            public void setTempletType(String templetType) {
                this.templetType = templetType;
            }

            public String getImageNum() {
                return imageNum;
            }

            public void setImageNum(String imageNum) {
                this.imageNum = imageNum;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public ScrollImageBean getScrollImage() {
                return scrollImage;
            }

            public void setScrollImage(ScrollImageBean scrollImage) {
                this.scrollImage = scrollImage;
            }

            public String getTagDesc() {
                return tagDesc;
            }

            public void setTagDesc(String tagDesc) {
                this.tagDesc = tagDesc;
            }

            public String getPhotoCount() {
                return photoCount;
            }

            public void setPhotoCount(String photoCount) {
                this.photoCount = photoCount;
            }

            public ItemImageBean getItemImage() {
                return itemImage;
            }

            public void setItemImage(ItemImageBean itemImage) {
                this.itemImage = itemImage;
            }

            public String getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(String commentNum) {
                this.commentNum = commentNum;
            }

            public String getItemID() {
                return itemID;
            }

            public void setItemID(String itemID) {
                this.itemID = itemID;
            }

            public String getAllow_praise() {
                return allow_praise;
            }

            public void setAllow_praise(String allow_praise) {
                this.allow_praise = allow_praise;
            }

            public String getVideoPlayID() {
                return videoPlayID;
            }

            public void setVideoPlayID(String videoPlayID) {
                this.videoPlayID = videoPlayID;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getItemType_VR() {
                return itemType_VR;
            }

            public void setItemType_VR(String itemType_VR) {
                this.itemType_VR = itemType_VR;
            }

            public String getOperate_time() {
                return operate_time;
            }

            public void setOperate_time(String operate_time) {
                this.operate_time = operate_time;
            }

            public static class ScrollImageBean {
                /**
                 * imgUrl1 : http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg
                 */

                private String imgUrl1;

                public String getImgUrl1() {
                    return imgUrl1;
                }

                public void setImgUrl1(String imgUrl1) {
                    this.imgUrl1 = imgUrl1;
                }
            }

            public static class ItemImageBean {
                /**
                 * imgUrl1 : http://p1.img.cctvpic.com/cportal/img/photoAlbum/page/performance/img/2018/3/12/1520856844414_7_640x480.jpg
                 */

                private String imgUrl1;

                public String getImgUrl1() {
                    return imgUrl1;
                }

                public void setImgUrl1(String imgUrl1) {
                    this.imgUrl1 = imgUrl1;
                }
            }
        }
    }
}
