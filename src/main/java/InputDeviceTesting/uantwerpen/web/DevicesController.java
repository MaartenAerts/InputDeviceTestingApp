package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Device;
import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.DeviceRepo;
import InputDeviceTesting.uantwerpen.repo.ResearchGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * Created by stuerjoris on 1/12/15.
 */

@Controller
@RequestMapping("/devices/")
public class DevicesController
{

    @Autowired
    private ResearchGroupRepo researchGroupRepo;

    @ModelAttribute("allResearcherGroups")
    public List<ResearchGroup> populateResearcherGroups() {
        List<ResearchGroup> researchGroupList = researchGroupRepo.findAll();
        Collections.sort(researchGroupList);
        return researchGroupList;
    }

    @Autowired
    private DeviceRepo deviceRepo;

    @RequestMapping(value = "devices", method = RequestMethod.GET)
    public String report()
    {
        return "devices";
    }

    @RequestMapping(value = "NewDevice", method = RequestMethod.POST)
    public String Register(@ModelAttribute("DeviceForm") Device device)
    {
        deviceRepo.save(device);
        return "redirect:/devices/devices";
    }



    @ModelAttribute("allDevices")
    public List<Device> populateDevices()
    {
        List<Device> deviceList = deviceRepo.findAll();
        return deviceList;
    }



    /*
    @RequestMapping(value = "deleteDevice")
    public String DeleteDevice(Model model){
        deviceRepo.delete(device);


    }
    */



}


