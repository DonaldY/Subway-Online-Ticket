package cn.yyf.tools.station;

import java.util.*;

/**
 * Created by DonaldY on 2017/5/19.
 */
public class ShortestPath {

    private List<Station> visitedList = new ArrayList<Station>();
    
    private NjBuilder njBuilder = NjBuilder.getInstance();

    private Map<Station, Map<Station,LinkedHashSet<Station>>> stationsMap = new HashMap<Station, Map<Station,LinkedHashSet<Station>>>();

    public LinkedHashSet<Station> getShortestPath(Station fromStation,  Station toStation) {

        calculate(fromStation, toStation);

        return this.stationsMap.get(fromStation).get(toStation);

    }



    private void calculate(Station fromStation,  Station toStation){

        if(this.visitedList.size() == this.njBuilder.getTotalStaion()){

            return;

        }

        if(!this.visitedList.contains(fromStation)){

            this.visitedList.add(fromStation);

        }

        if (!this.stationsMap.containsKey(fromStation)) {

            Map<Station, LinkedHashSet<Station>> map = new HashMap<Station, LinkedHashSet<Station>>();

            this.stationsMap.put(fromStation, map);

        }

        if (this.stationsMap.get(fromStation).isEmpty()) {

            List<Station> linkedStations = this.getAllLinkedStations(fromStation);

            for (Station station : linkedStations) {

                this.getVisitedStations(fromStation, station).add(station);

            }

        }

        Station parentStation = this.findShortestPath(fromStation);

        if(parentStation == toStation){

            return;

        }

        for(Station childStation : this.getAllLinkedStations(parentStation)){

            if(this.visitedList.contains(childStation)){

                continue;

            }

            int shortestPathNum = (this.getVisitedStations(fromStation, parentStation).size() - 1) + 1;


            if (this.getVisitedStations(fromStation, childStation).contains(childStation)) {

                if (this.getVisitedStations(fromStation, childStation).size() - 1 > shortestPathNum) {

                    this.getVisitedStations(fromStation, childStation).clear();

                    this.getVisitedStations(fromStation, childStation).addAll(this.getVisitedStations(fromStation,
                        parentStation));

                    this.getVisitedStations(fromStation, childStation).add(childStation);
                }

            } else {

                this.getVisitedStations(fromStation, childStation).addAll(this.getVisitedStations(fromStation, parentStation));

                this.getVisitedStations(fromStation, childStation).add(childStation);

            }

        }

        this.visitedList.add(parentStation);

        calculate(fromStation,toStation);
    }

    private LinkedHashSet<Station> getVisitedStations(Station fromStation, Station toStation) {

        Map<Station, LinkedHashSet<Station>> map = this.stationsMap.get(fromStation);

        if(map.get(toStation) == null){

            LinkedHashSet<Station> listSet = new LinkedHashSet<Station>();

            listSet.add(fromStation);

            map.put(toStation, listSet);

        }

        return map.get(toStation);

    }



    private Station findShortestPath(Station station){

        int minPath = Integer.MAX_VALUE;

        Station ss = null;

        for (Station s : this.stationsMap.get(station).keySet()) {

            if(this.visitedList.contains(s)){

                continue;

            }

            LinkedHashSet<Station> set = this.getVisitedStations(station, s);

            if (set.size() < minPath) {

                minPath = set.size();

                ss = s;

            }

        }

        return ss;

    }


    private List<Station> getAllLinkedStations(Station station){

        List<Station> linkedStaions = new ArrayList<Station>();

        for(List<Station> line : this.njBuilder.getLineSet()){

            if(line.contains(station)){

                Station s = line.get(line.indexOf(station));

                if(s.prev != null){

                    linkedStaions.add(s.prev);

                }
                if(s.next != null){

                    linkedStaions.add(s.next);

                }
            }
        }

        return linkedStaions;
    }

    public List<Station> getLinkedStations(Station _station) {

        return getAllLinkedStations(_station);

    }









    ////////////////////////////////Backup/////////////////////////////////////







    /*public LinkedHashSet<Station> getShortestPath(Station fromStation,  Station toStation) {

        calculate(fromStation, toStation);

        return fromStation.getVisitedStations(toStation);

    }

    private void calculate(Station fromStation,  Station toStation){
        
        if(this.visitedList.size() == this.njBuilder.getTotalStaion()){

            return;

        }
        
        if(!this.visitedList.contains(fromStation)){

            this.visitedList.add(fromStation);

        }
        
        if(fromStation.getOrderSetMap().isEmpty()){
            
            List<Station> linkedStations = this.getAllLinkedStations(fromStation);
            
            for(Station s : linkedStations){
                
                fromStation.getVisitedStations(s).add(s);
                
            }
            
        }
        
        Station parentStation = this.findShortestPath(fromStation);
        
        if(parentStation == toStation){

            return;

        }

        if (parentStation != null) {
            System.out.println("parent : " + parentStation.toString() + "  " + this.getAllLinkedStations
                (parentStation));
        }

        
        for(Station childStation : this.getAllLinkedStations(parentStation)){

            if(visitedList.contains(childStation)){
                continue;
            }
            
            int shortestPathNum = (fromStation.getVisitedStations(parentStation).size() - 1) + 1;

            if(fromStation.getVisitedStations(childStation).contains(childStation)){

                System.out.println("1");

                if((fromStation.getVisitedStations(childStation).size() - 1) > shortestPathNum){

                    System.out.println("2");

                    fromStation.getVisitedStations(childStation).clear();

                    fromStation.getVisitedStations(childStation).addAll(fromStation.getVisitedStations(parentStation));

                    fromStation.getVisitedStations(childStation).add(childStation);

                }
            } else {

                System.out.println("3");

                fromStation.getVisitedStations(childStation).addAll(fromStation.getVisitedStations(parentStation));

                fromStation.getVisitedStations(childStation).add(childStation);

            }
        }
        
        this.visitedList.add(parentStation);
        
        calculate(fromStation,toStation);
    }
    
    
    private Station findShortestPath(Station station){
        
        int minPath = Integer.MAX_VALUE;
        
        Station ss = null;
        
        for(Station s : station.getOrderSetMap().keySet()){

            if(this.visitedList.contains(s)){
                continue;
            }

            LinkedHashSet<Station> set = station.getVisitedStations(s);

            if(set.size() < minPath){

                minPath = set.size();

                ss = s;
            }
        }
        return ss;
    }

   
    private List<Station> getAllLinkedStations(Station station){
        
        List<Station> linkedStaions = new ArrayList<Station>();
        
        for(List<Station> line : this.njBuilder.getLineSet()){
            
            if(line.contains(station)){
                
                Station s = line.get(line.indexOf(station));
                
                if(s.prev != null){
                    
                    linkedStaions.add(s.prev);
                    
                }
                if(s.next != null){
                    
                    linkedStaions.add(s.next);
                    
                }
            }
        }
        
        return linkedStaions;
    }


    private String toListString(LinkedHashSet<Station> stations) {

        StringBuffer buffer = new StringBuffer();

        buffer.append("[");

        Iterator iterator = stations.iterator();

        while (iterator.hasNext()) {

            buffer.append((iterator.next()).toString());

            if (iterator.hasNext()) {

                buffer.append(",");

            }

        }

        buffer.append("]");

        return buffer.toString();

    }*/



}
