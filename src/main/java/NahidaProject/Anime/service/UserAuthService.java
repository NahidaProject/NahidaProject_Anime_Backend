package NahidaProject.Anime.service;

import NahidaProject.Anime.entity.UserData;
import NahidaProject.Anime.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData data = userMapper.findUserByName(username);
        if(data==null) throw new UsernameNotFoundException("用户"+username+"登录失败, 用户名不存在!");
        return User.withUsername(data.getUsername()).password(data.getPassword()).roles(data.getRole()).build();
    }
}
