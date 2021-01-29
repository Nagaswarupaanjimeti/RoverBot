package controller;

import constants.RoverBotConstants;
import pojo.Move;
import pojo.Position;
import src.main.constants.RoverBotConstants;
import src.main.pojo.Move;
import src.main.pojo.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoverBotLogic {

    public static void main(String[] args){
        src.main.service.RoverBotLogic roverBotLogic = new src.main.service.RoverBotLogic();
        Position position = new Position("N",10,10);
        ArrayList<Move> moves = new ArrayList<>();
        moves.add(new Move("1",90,0,10,0));
        moves.add(new Move("2",0,180,0,20));

        roverBotLogic.getCurrentPosition(position, moves);
        System.out.println("Current Position: " + roverBotLogic.getCurrentPosition(position, moves));


    }

    Position getCurrentPosition(Position position, ArrayList<Move> moveArr) {
        Position currentPosition = new Position(null,0,0);
        List<Move> moveList = moveArr.stream().sorted((o1, o2) -> o1.getOrder().compareTo(o2.getOrder()))
                .collect(Collectors.toList()); //To ensure Move details are in Order
        for (Move move: moveList) {
            //to figure out whether rotation has to be in right or left used leftcount & right count
            //so accordingly i can use ROTATE Map to make decision
            //eg: if Rotation is Left then directions will be picked like North, West, South & East (default) which
            // will be changed in below else if cases
            int leftCount = (RoverBotConstants.ZERO != move.getLeftRotation()
                    && RoverBotConstants.THREESIXTY != move.getLeftRotation()) ?
                    RoverBotConstants.ROTATE_COUNT.get(move.getLeftRotation()):0;
            int rightCount = (RoverBotConstants.ZERO != move.getRightRotation()
                    && RoverBotConstants.THREESIXTY != move.getRightRotation()) ?
                    RoverBotConstants.ROTATE_COUNT.get(move.getRightRotation()):0;
            ArrayList<String> positionDirection;
            if(RoverBotConstants.ZERO  == leftCount && RoverBotConstants.ZERO == rightCount){
                currentPosition.setDirection(position.getDirection());
            }else if(RoverBotConstants.ZERO < leftCount && RoverBotConstants.ZERO == rightCount){
                positionDirection = RoverBotConstants.ROTATE.get("L");
                for( int i=0; i< positionDirection.size(); i++){
                    if(positionDirection.get(i).equals(position.getDirection())) {
                        currentPosition.setDirection(
                                positionDirection.get(
                                        (i+leftCount >=4 ? i+leftCount -4 : i+leftCount)
                                )
                        );
                    }
                }
            }else if (RoverBotConstants.ZERO < rightCount && RoverBotConstants.ZERO == leftCount){
                positionDirection = RoverBotConstants.ROTATE.get("R");
                for( int i=0; i< positionDirection.size(); i++){
                    if(positionDirection.get(i).equals(position.getDirection())) {
                        currentPosition.setDirection(
                                positionDirection.get(
                                        (i+rightCount >=4 ? i+rightCount -4 : i+rightCount)
                                )
                        );
                    }
                }
            }
            //If direction is East or West then movement i.e., forward or backward will be on X-axis
            //If direction is North or South then movement i.e., forward or backward will be on Y-axis
            // if movement is forward then we have to add else subtract in case of E or N
            // if movement is forward then we have to subtract else add in case of W or S
            if(RoverBotConstants.E.equals(currentPosition.getDirection())){
                currentPosition.setY(position.getY());
                if(move.getMoveBackward()!=0 && move.getMoveForward()==0){
                    currentPosition.setX(position.getX()-move.getMoveBackward());
                }else if(move.getMoveBackward() ==0 && move.getMoveForward() != 0){
                    currentPosition.setX(position.getX()+move.getMoveForward());
                }
            }else if(RoverBotConstants.W.equals(currentPosition.getDirection())){
                currentPosition.setY(position.getY());
                if(move.getMoveBackward()!=0 && move.getMoveForward()==0){
                    currentPosition.setX(position.getX()+move.getMoveBackward());
                }else if(move.getMoveBackward() ==0 && move.getMoveForward() != 0){
                    currentPosition.setX(position.getX()-move.getMoveForward());
                }
            }else if(RoverBotConstants.N.equals(currentPosition.getDirection())){
                currentPosition.setX(position.getX());
                if(move.getMoveBackward()!=0 && move.getMoveForward()==0){
                    currentPosition.setY(position.getY()-move.getMoveBackward());
                }else if(move.getMoveBackward() ==0 && move.getMoveForward() != 0){
                    currentPosition.setY(position.getY()+move.getMoveForward());
                }
            }else{
                currentPosition.setX(position.getX());
                if(move.getMoveBackward()!=0 && move.getMoveForward()==0){
                    currentPosition.setY(position.getY()+move.getMoveBackward());
                }else if(move.getMoveBackward() ==0 && move.getMoveForward() != 0){
                    currentPosition.setY(position.getY()-move.getMoveForward());
                }
            }
            position = currentPosition;
        }
        return  position;

    }
}