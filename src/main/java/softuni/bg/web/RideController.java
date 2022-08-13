package softuni.bg.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.*;
import softuni.bg.service.RideService;
import softuni.bg.service.RideStatusService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;
    private final RideStatusService rideStatusService;

    public RideController(RideService rideService, RideStatusService rideStatusService) {
        this.rideService = rideService;
        this.rideStatusService = rideStatusService;
    }

    @GetMapping("/publish")
    public String publishRide(Model model) {

        if (!model.containsAttribute("publishRideModel")) {
            model.addAttribute("publishRideModel", new PublishRideDto());
        }

        return "publish-ride";
    }

    @PostMapping("/publish")
    public String publishRideConfirm(@Valid PublishRideDto publishRideModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes,
                                     @AuthenticationPrincipal UserDetails userDetails
    ) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("publishRideModel", publishRideModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.publishRideModel",
                            bindingResult);

            return "redirect:publish";
        }

        this.rideService.saveRide(publishRideModel, userDetails);

        return "redirect:/";
    }

    @GetMapping("/search")
    @Transactional
    public String searchQuery(@Valid SearchRideDto searchRideDto,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("searchRideModel", searchRideDto);
            model.addAttribute(
                    "org.springframework.validation.BindingResult.searchRideModel",
                    bindingResult);

            return "search-ride";
        }

        if (!model.containsAttribute("searchRideModel")) {
            model.addAttribute("searchRideModel", searchRideDto);
        }

        if (!searchRideDto.isEmpty()) {
            model.addAttribute("rides", rideService.searchRide(searchRideDto));
        }

        return "search-ride";
    }

    @GetMapping("/details/{id}")
    @Transactional
    public String getRide(@PathVariable("id") Long rideId, Model model) {
        RideDetailsDto rideDetails = this.rideService.getRide(rideId);

        model.addAttribute("ride", rideDetails);

        return "ride-details";
    }

    @GetMapping("/request-join/{id}")
    @Transactional
    public String requestToJoinRide(@PathVariable("id") Long rideId, Model model,
                                    @AuthenticationPrincipal UserDetails userDetails
    ) {
        RideDetailsDto rideDetails = this.rideService.getRide(rideId);

        model.addAttribute("ride", rideDetails);

        this.rideService.requestToJoinRide(rideId, userDetails);

        return "ride-join";
    }

    @GetMapping("/consider-request")
    @Transactional
    public String considerRequestToJoinRide(Model model,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        List<ConsiderRideDto> considerRideDtos = this.rideService.considerRideRequest(userDetails);

        model.addAttribute("rideConsider", considerRideDtos);


        return "ride-consider";
    }

    @GetMapping("/approve-request/{rideStatusId}/{passengerId}/{rideId}")
    @Transactional
    public String approveRequest(
            @PathVariable("rideStatusId") Long id,
            @PathVariable("passengerId") Long passengerId,
            @PathVariable("rideId") Long rideId) {

        boolean passengerAdded = this.rideService.addPassengerToRide(rideId, passengerId);

        if (passengerAdded) {
            this.rideStatusService.approveRide(id);
        } else {
            return "ride-reject";
        }

        return "ride-approve";
    }

    @GetMapping("/reject-request/{rideStatusId}")
    @Transactional
    public String rejectRequest(@PathVariable("rideStatusId") Long id) {

        this.rideStatusService.rejectRide(id);

        return "ride-reject";
    }

    @GetMapping("/my-rides")
    @Transactional
    public String displayMyRides(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        List<RideDetailsDto> myRidesByUsername = this.rideService.findMyRidesByUsername(userDetails.getUsername());

        model.addAttribute("rides", myRidesByUsername);

        return "my-rides";
    }

    @GetMapping("my-rides/details/{id}")
    @Transactional
    public String getMyRide(@PathVariable("id") Long rideId, Model model) {
        RideDetailsDto rideDetails = this.rideService.getRide(rideId);

        model.addAttribute("ride", rideDetails);

        return "my-rides-details";
    }

}

