package NahidaProject.Anime.controller;

import NahidaProject.Anime.entity.CommentData;
import NahidaProject.Anime.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Comments")
@ResponseBody
public class CommentController {
    @Resource
    CommentService commentService;
    @RequestMapping("/GetCommentsByAnimeID/{AnimeID}")
    private List<CommentData> GetCommentsByAnimeID(@PathVariable String AnimeID){
        return commentService.GetCommentsByAnimeID(AnimeID);
    }
    @RequestMapping(value = "/AddCommentByAnimeID",method = RequestMethod.POST)
    private void AddCommentByAnimeID(@RequestBody CommentData commentData){
        commentService.AddCommentByAnimeID(commentData);
    }
}
