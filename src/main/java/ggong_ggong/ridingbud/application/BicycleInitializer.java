package ggong_ggong.ridingbud.application;

import ggong_ggong.ridingbud.domain.BicycleRental;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BicycleInitializer implements ApplicationRunner {

    private final FacilityService facilityService;
    private final String data = """
           1,설화명곡역,0,35.79877,128.4887,없음,없음,운영안함
           1,화원역,0,35.80519,128.5005,없음,없음,운영안함
           1,대곡역,8,35.81,128.5124,지하 2층 설화명곡방면 EL 통로 옆,있음,06시-20시
           1,진천역,8,35.81476,128.5227,지하 1층 설화명곡방면 엘리베이터 옆,있음,06시-20시
           1,서부정류장역,5,35.83822,128.5578,지하 1층 고객안내센터 옆 표내는곳 통과 후 복도 문 앞,있음,06시-20시
           1,칠성시장역,9,35.87691,128.6052,지하 1층 1번 출구 방향,있음,06시-20시
           1,동대구역,7,35.8783,128.6279,지하 1층 1번 출구 방향,있음,06시-20시
           1,동촌역,20,35.88734,128.6489,지하 3층 고객안내센터 앞,있음,06시-20시
           1,신기역,10,35.86749,128.7018,지하 1층 대합실 개집표기 앞(설화명곡방면),있음,06시-20시
           2,대실역,22,35.85783,128.4652,지하 2층 화장실 입구 왼쪽 방향,있음,06시-20시
           2,이곡역,10,35.85127,128.516,지하 1층 쏘유아울렛 의류매장 옆,있음,06시-20시
           2,반월당역,0,35.86539,128.5935,없음,없음,운영안함
           2,경대병원역,17,35.86368,128.6031,지하 1층 화장실옆,있음,06시-20시
           3,남산,4,35.85739,128.5835,지상 1층 3고객센터 앞,있음,06시-20시""";

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BicycleRental bicycleRental;
        String[] lines = data.split("\n");

        for (String line : lines) {
            String[] tokens = line.split(",");

            bicycleRental = BicycleRental.builder()
                    .x(Float.parseFloat(tokens[3]))
                    .y(Float.parseFloat(tokens[4]))
                    .stationName(tokens[1])
                    .totalCount(Short.parseShort(tokens[2]))
                    .remainder(Short.parseShort(tokens[2]))
                    .operationTime(tokens[7])
                    .detailLocation(tokens[5])
                    .build();

            facilityService.saveBicycle(bicycleRental);
        }
    }
}
