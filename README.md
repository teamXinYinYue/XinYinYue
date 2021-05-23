# XinYinYue项目说明

## 项目api

OrderManyMusicBysize
@ResponseBody
 @RequestMapping(value="/OrderManyMusicBysize")
public java.util.HashMap OrderManyMusicBysize(java.lang.Integer size)
deleteManyMusicBymids
@ResponseBody
 @RequestMapping(value="/deleteManyMusicBymids",
                method=POST)
public java.util.HashMap deleteManyMusicBymids(java.lang.Integer[] mids)
updateOneMusicBymusic
@ResponseBody
 @RequestMapping(value="/updateOneMusicBymusic",
                method=POST)
public java.util.HashMap updateOneMusicBymusic(@RequestBody
                                                                                                                                              Music music)
pageManyMusic
@ResponseBody
 @RequestMapping(value="/pageManyMusic")
public java.util.HashMap pageManyMusic(java.lang.Integer pageNum,
                                                                                                java.lang.Integer pageSize)
pageManyMusicByMC
@ResponseBody
 @RequestMapping(value="/pageManyMusicByMC")
public java.util.HashMap pageManyMusicByMC(java.lang.String cname,
                                                                                                        java.lang.String sname,
                                                                                                        java.lang.String mname,
                                                                                                        java.lang.Integer pageNum,
                                      

## 项目网址

http://121.5.149.137:8080/
