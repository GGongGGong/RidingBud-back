package ggong_ggong.ridingbud.api;

import ggong_ggong.ridingbud.api.req.FavoriteRequest;
import ggong_ggong.ridingbud.application.FavoriteService;
import ggong_ggong.ridingbud.domain.FavoriteCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;
    @PostMapping()
    public HttpStatus postFavorite(@RequestBody FavoriteRequest request, Long userId){
        favoriteService.postFavorite(userId, request.getCourseId());
        return HttpStatus.CREATED;
    }

    @DeleteMapping()
    public void deleteFavorite(@RequestParam Long courseId,Long userId){
        favoriteService.deleteFavorite(userId,courseId);
    }
}
