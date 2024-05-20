import java.util.Scanner;

public class UserInput {
    public void run(){
        PhoneFactory factory = PhoneFactory.getFactory();
        Phone phone = factory.createPhone("123-456-7890", 10.0, 0.5);

        Scanner scan = new Scanner(System.in);
        
        // Добавление наблюдателя
        PhoneObserver observer = new PhoneObserver("Наблюдатель");
        PhoneSubject subject = new PhoneSubject();
        subject.attach(observer);
        CallService call = CallService.createCallService();
        int c = 0;
        while (c != 6){
            if (phone instanceof PhoneDecorator){
                System.out.println("Меню:\n1)Позвонить\n2)Пополнить баланс\n3)Проверить баланс\n4)Пополнить баланс внешней платежной системой\n5)Состояние телефона\n6)Выключить телефон\n");
            }
            else{
                System.out.println("Меню:\n1)Позвонить\n2)Пополнить баланс\n3)Проверить баланс\n4)Улучшить телефон\n5)Состояние телефона\n6)Выключить телефон\n");
            }
            try{
                c = Integer.valueOf(scan.next());
            } catch (NumberFormatException e){
                c = 0;
            }
            switch (c){
                case 1:
                    if(call.initiateCall(phone)){
                        subject.setState("Звонок");
                        System.out.println("Нажмите 1 чтобы ответить или 2 чтобы завершить звонок");
                        int zvonok = scan.nextInt();
                        switch (zvonok){
                            case 1:
                                call.receiveCall(phone);
                                subject.setState("Разговор");
                                System.out.println("Нажмите любую кнопку чтобы закончить разговор");
                                scan.next();
                                call.terminateCall(phone);
                                subject.setState("Ожидание");
                                break;
                            case 2:
                                call.terminateCall(phone);
                                subject.setState("Ожидание");
                                break;
                            default:
                                System.out.println("Выберите функцию от 1 до 2");
                                break;
                        }
                        
                    }
                    else{
                        subject.setState("Заблокирован");
                    }
                    break;
                case 2:
                    Double money = 0.0;
                    System.out.println("Введите сумму на которую вы хотите пополнить баланс:");
                    try{
                        money = Double.valueOf(scan.next());
                    } catch (NumberFormatException e){
                        System.out.println("Ошибка. Введена некорректная сумма");
                        money = 0.0;
                    }
                    phone.recharge(money);
                    subject.setState("Баланс пополнен");
                    break;
                case 3:
                    System.out.println("Ваш баланс = "+phone.getBalance());
                    break;
                case 4:
                    if (phone instanceof PhoneDecorator){
                        ExternalPaymentSystem externalPaymentSystem = new ExternalPaymentSystem();
                        PaymentGateway paymentGateway = new PaymentAdapter(externalPaymentSystem);
                        System.out.println("Введите сумму на которую вы хотите пополнить баланс:");
                        try{
                            money = Double.valueOf(scan.next());
                        } catch (NumberFormatException e){
                            System.out.println("Ошибка. Введена некорректная сумма");
                            money = 0.0;
                        }
                        ((PhoneDecorator)phone).rechargeViaPaymentGateway(paymentGateway, money);
                        subject.setState("Баланс пополнен");
                    }
                    else{
                        Phone smartPhone = new PhoneDecorator(phone);
                        phone = smartPhone;
                    }
                    break;
                case 5:
                    System.out.println(subject.getState());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Выберите функцию от 1 до 6");
                    break;
            }
        }
        scan.close();
    }
}
