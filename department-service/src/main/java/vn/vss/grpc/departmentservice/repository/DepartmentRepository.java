package vn.vss.grpc.departmentservice.repository;

import org.springframework.stereotype.Repository;
import vn.vss.grpc.common.repository.BaseRepository;
import vn.vss.grpc.departmentservice.entity.Department;

/**
 * @author CuongLM18
 * @created 06/12/2022 - 4:46 PM
 * @project grpc
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department, Long> {
}
