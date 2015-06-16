
package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.Mitarbeiter;
import demo.service.MitarbeiterService;

@Controller
public class Jpa_Controller
{
    @Autowired
    private MitarbeiterService mitarbeiter;
   
    @RequestMapping(value="/mitarbeiter", method=RequestMethod.GET)
    @ResponseBody
    public String getMitarbeiter()
    {
        StringBuilder ret = new StringBuilder();
        List<Mitarbeiter> a = mitarbeiter.findByNameLike("%");
       
        for (Mitarbeiter b : a)
        {
            ret.append(b.toString());
            ret.append('\n');
        }
       
        return ret.toString();
    }
   
    @RequestMapping(value ="/mitarbeiter/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getMitarbeiter(@PathVariable int id)
    {
        Mitarbeiter a = mitarbeiter.findOne(id);
        if (a != null)
            return a.toString();
        return "User " + id + " does not exist.";
    }
   
    @RequestMapping(value ="/mitarbeiter", method=RequestMethod.POST)
    @ResponseBody
    public String createMitarbeiter(
            @RequestParam(value="id", required=true) Integer id,
            @RequestParam(value="name", required=true) String name)
    {
        Mitarbeiter a = new Mitarbeiter();
        a.setIdMitarbeiter(id);
        a.setName(name);
        mitarbeiter.save(a);
        return a.toString();
    }
   
    @RequestMapping(value ="/mitarbeiter/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public String deleteMitarbeiter(@PathVariable int id)
    {
        Mitarbeiter a = mitarbeiter.findOne(id);
        if (a != null)
        {
            mitarbeiter.delete(id);
            return "OK";
        }
        return "User " + id + " does not exist.";
    }
}

