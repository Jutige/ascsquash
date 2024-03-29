package com.asc.squash.exposition.security.jwt;

import com.asc.squash.application.UtilisateurDetailService;
import com.asc.squash.application.service.IUserManagment;
import com.asc.squash.infrastructure.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true" ,allowedHeaders = {"count", "Authorization"},
		exposedHeaders = {"count", "Authorization","x-auth-token"},
		methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenManager jwtTokenUtil;

	@Autowired
	private UtilisateurDetailService userDetailsService;

	@Autowired
	private IUserManagment userManagment;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody final JwtRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		userManagment.updateDateConnexion(userDetails.getUsername());

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(final String username, final String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (final DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (final BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
