package Service;


import com.nexus.drone.drone.domain.dto.state.NewStateRequest;
import com.nexus.drone.drone.domain.model.DroneState;
import org.springframework.stereotype.Service;
import repository.DroneStateRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StateService {
    private final DroneStateRepository repository;
    public StateService(DroneStateRepository repository){
        this.repository = repository;
    }
    public List<DroneState> getModels() {
        return repository.findAll();
    }

    public DroneState newState(NewStateRequest newStateRequest) {
        DroneState model =DroneState.builder().desc(newStateRequest.getDesc()).build();
        return repository.save(model);
    }

    public DroneState getState(UUID uid) {
        return repository.findById(uid).orElseThrow();
    }
    public void delete(DroneState model){
        repository.delete(model);
    }
    public DroneState update(DroneState model, NewStateRequest newStateRequest){
        model.setDesc(newStateRequest.getDesc());
        model = repository.save(model);
        return model;
    }

}
