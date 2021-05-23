# XinYinYue项目说明

## 项目api

findManyCommentBymid
@ResponseBody
 @RequestMapping(value="/findManyCommentBymid")
public java.util.HashMap findManyCommentBymid(java.lang.Integer mid)
findManyCommentByuid
@ResponseBody
 @RequestMapping(value="/findManyCommentByuid")
public java.util.HashMap findManyCommentByuid(java.lang.Integer uid)
addOneCommentByComment
@ResponseBody
 @RequestMapping(value="/addOneCommentBycomment",
                method=POST)
public java.util.HashMap addOneCommentByComment(@RequestBody
                                                                                                                                                Comment comment)
deleteManyCommentBycoids
@ResponseBody
 @RequestMapping(value="/deleteManyCommentBycoids",
                method=POST)
public java.util.HashMap deleteManyCommentBycoids(java.lang.Integer[] coids)
updateOneCommentByComment
@ResponseBody
 @RequestMapping(value="/updateOneCommentBycomment",
                method=POST)
public java.util.HashMap updateOneCommentByComment(@RequestBody
                                                                                                                                                      Comment comment)
pageManyCommentBymid
@ResponseBody
 @RequestMapping(value="/pageManyCommentBymid")
public java.util.HashMap pageManyCommentBymid(java.lang.Integer mid,
                                                                                                              java.lang.Integer pageNum,
                                                                                                              java.lang.Integer pageSize)
pageManyCommentByuid
@ResponseBody
 @RequestMapping(value="/pageManyCommentByuid")
public java.util.HashMap pageManyCommentByuid(java.lang.Integer uid,
                                                                                                              java.lang.Integer pageNum,
                                                                                                              java.lang.Integer pageSize)
                                      

## 项目网址

http://121.5.149.137:8080/
