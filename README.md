# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 요구사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를
이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.  

  * [예시]

  |상대방(컴퓨터)의 수|힌트| 
  |--------------|---|
  |426|1스트라이크|
  |456|1스트라이크 1볼|
  |789|1낫싱|

* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 
  * 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 
  * 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고
  * 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
  
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록
 * [x] 볼 숫자를 검증 하는 기능 
   * 1부터 9까지 서로 다른 수로 이루어져야 한다. 불일치시 IllegalArgumentException 발생
   
 * [X] BaseBall을 체크 하는 기능 
   * 중복된 숫자를 관리시 나올시 에러를 발생한다.
   * 세개의 볼만 가질수 있다.
   
 * [X] 각 NumberBaseBall을 체크하여 힌트의 결과를 제공하는 기능 
     * 같은 수가 있으면 스트라이크, 다른 자리에 숫자가 있으면 볼, 숫자가 없으면 낫싱, 맞추면 승리
   
 * [X] 컴퓨터의 랜덤한 숫자를 생성하는 기능
   * 임의의 3개의 수 선택
   * 결과를 리턴하는 객체 생성
 
 * [X] 플레이어의 숫자를 검증 하는 기능
   * 사용자가 숫자를 잘 못 입력할 경우 IllegalArgumentException 발생한다.
   
 * [X] 플레이어의 입력값과 컴퓨터의 입력값을 비교하여 정답이면 승리, 틀리면 힌트를 화면에 제공하는 기능
   * 플레이어의 입력을 오 입력시 어플리케이션 종료 
   * 틀리면 힌트를 화면 출력 
     * 예시) 1볼 1스트라이크 
 
 * [X] 게임이 종료되면 완전히 종료 혹은 다시 시작 기능 

## 클래스 목록 
* controller 패키지
  * GameController : 숫자야구게임의 컨트롤러 역할을 담당
  
* domain 패키지 (model 담당)
  * Class
    * Ball : 숫자야구의 한자리의 볼넘버를 도메인을 담당.
    * User : Computer 와 Player의 상위클래스
    * Computer: 컴퓨터 도메인을 담당. 
      * 랜덤 값 생성 
    * Player : 플레이어의 도메인을 담당
  
    * Game : 게임도메인을 담당.
    * NumberBaseBall : 숫자야구넘버 3자리에 대한 도메인 담당.
    * NumberBaseBallResult : 숫자야구결과에 대한 상태를 담당하는 BO
  
  * Enum
    * GameStatus: 게임 도메인에 대한 상태 
    * Hint : 볼, 스트라이크,낫싱등 힌트 상태
    * NumberBaseBallResultStatus : 숫자야구게임 플레이어와 컴퓨터간에 대한 상태
    
  * ServiceClass : 컴퓨터와 플레이어간의 결과를 확인하는 비지니스로직을 담당하는 서비스 클래스 
    

* util 패키지 
  * ArrayUtil : Array에 대한 Util 클래스

* view 패키지 
  * InputView : 입력값화면을 담당
  * OutPutVie : 출력 화면을 담당
  
 

## 프로그램 제약 사항

* 숫자 야구게임을 실행하는 시작점은 src/main/java 폴더의 baseball.Application의 main()이다. 
* 숫자 야구게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다. 
* JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하
  는 Randoms 및 Console API를 사용하여 구현해야 한다.
* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
* 프로그램 구현을 완료했을 때 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한
  다. 테스트가 실패할 경우 0점 처리한다.
* ApplicationTest에서 제공하는 2개의 Test Case는 숫자 야구게임 구현을 위한 최소한의 Test Case이다.
* 필수 요구사항은 아니지만 제공하는 소스 코드를 참고해 숫자 야구게임을 위한 모든 Test Case를 추가해 보는 것도
  테스트에 대한 좋은 연습이 될 수 있다.


* 자바 코드 컨벤션을 지키면서 프로그래밍한다. •https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
* 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다. •else 예약어를 쓰지 않는다.
* 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다. 
  * 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
* 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

* 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
* 힌트는 MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집
중한다.
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해
사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현한다.





  
## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
